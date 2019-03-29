package com.ruoyi.common.utils.file.qiniu.domain;

import lombok.Data;

/**
 * @author: dong.chao
 * @create: 2019-03-29 13:02
 * @description: 七牛云返回实体,用于将json转换为实体
 **/

@Data
public class MyPutRet {

    public String key;

    public String hash;

    public String bucket;

    public long fsize;
}
