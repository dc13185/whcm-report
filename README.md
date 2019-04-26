## 武汉传媒学院小程序应用管理（基于RuoYi3.0开发）
目前暂且将功能代码出来，以应付19年4月中旬活动，并无优化，记录其需要优化的功能。
以便日后有其他人进行开发,记录需要优化的功能




### 集成了七牛云
    配置文件:qiniu.yml
    操作类：qiniuUtils
### 上传业务文件到服务器(图片、视频)
    未完成功能：1.未判断文件类型.判断是图片还是文件
               2.上传UI组件并不美观，没有裁剪等功能
               3.上传没有进度条
               4.删除依附的文件记录没有删除文件（如删除了轮播图没有删除具体的图片 只是在数据库中进行了删除）
               4.未做具体的文件上传限制
               5.没有上传到具体的文件服务器(FTP服务器)上(并不算对象存储)
    
## 接口文档

####  登录

| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/user/login | encryptedData：加密信息<br>vi:偏移量 <br>code:密钥| status:0 失败,1成功<br>msg：说明<br>userInfo:成功后返回用户信息 |

#### 获取轮播图
| 地址  | 响应参数 |
|:------: | :------: |
| /wx/exhibition/getBanners  | result |


####  获取院系
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/exhibition/getTypes | | result |


####  根据院系获取到节目
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/exhibition/getPrograms | typeId：院系id<br>status:获取状态 1:获取点赞书 0：获取评论数 ,wxUserOpenId:openid| programs：节目信息(节目信息中的 Votes即表示数量 传参status为0时表示投票数 为1时表示点赞) ，isVote:表示是否点过赞或者是否投过票 1为是|

### 获取评论接口
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/exhibition/getComments | programId：节目id  | comments:评论信息 |


### 评论接口
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/comment/sendComment | programId：节目id<br>xwUserOpenid:openId  | status:1 代表评论成功 0 评论不成功<br>msg:返回信息 |


### 点赞接口
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/comment/like | programId：节目id<br>xwUserOpenid:openId  | status:1  <br> msg:返回信息 |


### 投票接口
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/comment/vote | programId：节目id<br>xwUserOpenid:openId  | status:1 代表评论成功 0 评论不成功 <br> msg:返回信息 |


webSocket地址 :/wx/websocket/link
### 留言板留言
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/webSocket/sendMassage | wxOpenId：openId<br>avatarUrl:头像<br> nickname:昵称 <br> msg:消息 | 返回success代表成功 |


### 获取点赞数 评论；‘1·数接口
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/exhibition/toMyMian | wxUserOpenId：openId | status:1 代表评论成功 0 评论不成功 <br> comments:评论数 fabulous:点赞数和投票数的总和 |


### 根据openId获取到评论的具体内容
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/exhibition/getCommentsByOpenId | openid: | status:1 代表评论成功 0 评论不成功 <br> comments:返回信息 |


### 根据openId获取到点赞的信息
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/exhibition/getFabulousByOpenId | openid: | status:1 代表评论成功 0 评论不成功 <br> comments:返回信息 |



### 获取留言板内容
| 地址  | 请求参数 | 响应参数 |
|:------: | :------: | :------: |
| /wx/webSocket/getMassage | count:返回条数 为20的倍数 <br> 如写 count:1 返回20条 count2:返回40条 | status:1 代表评论成功 0 评论不成功 <br> messageList:返回信息 |


