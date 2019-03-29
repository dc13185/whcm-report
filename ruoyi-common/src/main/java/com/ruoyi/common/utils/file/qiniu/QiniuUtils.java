package com.ruoyi.common.utils.file.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.ruoyi.common.utils.file.qiniu.domain.MyPutRet;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * @author: dong.chao
 * @create: 2019-03-29 11:47
 * @description: 七牛云上传工具类
 **/
public class QiniuUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(QiniuUtils.class);

    //设置好账号的ACCESS_KEY和SECRET_KEY
    private static String ACCESS_KEY = "2GzvBFr0wjzDYxS8y9cnH4tlfCwjrYk-Yk52FYQo";

    private static String SECRET_KEY = "IkLX1-wEJpqRN8tsnbL8_WAhxzYFc1eDN8bYTh5k";

    //域名
    private static String DOMAIN = "img.dchope.cn";

    //要上传的空间
    private static String BUCKET_NAME = "dchome"; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

    //密钥配置
    private static Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);

    //构造一个带指定Zone对象的配置类  zone2 -> 华南地区
    private static Configuration cfg = new Configuration(Zone.zone2());

    //创建上传对象
    private static UploadManager uploadManager = new UploadManager(cfg);

    //获取上传凭证
    private static String upToken ;





    public static String getUpToken(){
       if(StringUtils.isBlank(upToken)){
           upToken = auth.uploadToken(BUCKET_NAME);
       }
       return upToken;
    }

    /** 普通上传[根据文件路径]
     *
     * @param file
     * @param filename 上传到七牛后保存的文件名
     * @return [String] 返回文件url
     */
    public static String upload(String file, String filename){
        String url = null;
        try {
            //调用put方法上传
            Response res = uploadManager.put(file, filename, getUpToken());

            MyPutRet myPutRet=res.jsonToObject(MyPutRet.class);

            //此时Key为文件名
             url = DOMAIN + "//" + myPutRet.getKey();
        } catch (QiniuException e) {
            LOGGER.info("upload error:{}",e.getMessage());
            Response r = e.response;
            // 请求失败时打印的异常的信息
            System.out.println(r.toString());
            try {
                //响应的文本信息
                System.out.println(r.bodyString());
            } catch (QiniuException e1) {
                //ignore
            }
        }
        return url;
    }

    /**
     *springmvc MultipartFile 上传文件流
     * @param file 上传文件流
     * @param filename 文件名
     * @return
     * @throws Exception
     */

    public static String updateFile(MultipartFile file, String filename) throws Exception {
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        try {
            InputStream inputStream=file.getInputStream();
            ByteArrayOutputStream swapStream = new ByteArrayOutputStream();
            byte[] buff = new byte[600]; //buff用于存放循环读取的临时数据
            int rc = 0;
            while ((rc = inputStream.read(buff, 0, 100)) > 0) {
                swapStream.write(buff, 0, rc);
            }

            byte[] uploadBytes  = swapStream.toByteArray();
            try {
                Response response = uploadManager.put(uploadBytes,filename,getUpToken());
                //解析上传成功的结果
                DefaultPutRet putRet;
                putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
                return putRet.key;

            } catch (QiniuException ex) {
                Response r = ex.response;
                System.err.println(r.toString());
                try {
                    System.err.println(r.bodyString());
                } catch (QiniuException ex2) {
                }
            }
        } catch (UnsupportedEncodingException ex) {
        }
        return null;
    }


    public static void main(String[] args) {
        upload("F:\\749b33c4a9e1448d05fedea550be5bea.jpg","text.jpg");

    }


}
