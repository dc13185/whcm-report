package com.ruoyi.common.utils.file.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;


/**
 * @author: dong.chao
 * @create: 2019-03-29 11:47
 * @description: 七牛云上传工具类
 **/
@Component
public class QiniuUtils {

    private static final Logger logger = LoggerFactory.getLogger(QiniuUtils.class);


    //域名
    private static String DOMAIN;
    //要上传的空间
    private static String BUCKET_NAME ; //对应要上传到七牛上 你的那个路径（自己建文件夹 注意设置公开）

    //密钥配置
    private static Auth auth ;

    //构造一个带指定Zone对象的配置类  zone2 -> 华南地区
    private static Configuration cfg = new Configuration(Zone.zone2());

    //创建上传对象
    private static UploadManager uploadManager = new UploadManager(cfg);

    //获取上传凭证
    private static String upToken ;




    @Value(value = "${qiniu.domain}")
    public void setDOMAIN(String DOMAIN) {
        QiniuUtils.DOMAIN = DOMAIN;
    }


    @Value(value = "${qiniu.bucket_name}")
    public  void setBucketName(String bucketName) {
        QiniuUtils.BUCKET_NAME = bucketName;
    }


   public static String getUpToken(){
        if(StringUtils.isBlank(upToken)){
            upToken = auth.uploadToken(BUCKET_NAME);
        }
        return upToken;
    }

    /**
    * @Description:  获得token
    * @Param: [access_key, secret_key]
    * @return:
    * @Author: dong.chao
    * @Date: 2019/4/2
    */
    public QiniuUtils(@Value("${qiniu.access_key}") String access_key,@Value("${qiniu.secret_key}") String secret_key) {
       if(auth == null){
           auth = Auth.create(access_key, secret_key);
       }
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

            DefaultPutRet defaultPutRet=res.jsonToObject(DefaultPutRet.class);

            //此时Key为文件名
            url = DOMAIN + "//" + defaultPutRet.key;
        } catch (Exception e) {
            logger.info("qiniu upload error:{}",e.getMessage());
        }
        return url;
    }


    /**
     *springmvc MultipartFile 上传文件流
     * @param file 上传文件流
     * @param filename 文件名
     * @return [String] 返回文件路径
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
                String url = DOMAIN + "/" + putRet.key;
                return url;

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

    }


}
