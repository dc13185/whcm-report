package com.whcm.report.controller.wx;

import com.whcm.report.domain.Comment;
import com.whcm.report.domain.Fabulous;
import com.whcm.report.service.ICommentService;
import com.whcm.report.service.IFabulousService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dong.chao
 * @create: 2019-04-07 16:26
 * @description: 评论点赞接口
 **/


@RestController
@RequestMapping("/wx/comment")
public class WxCommentController {

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IFabulousService fabulousService;
    
    /**
    * @Description: 评论接口
    * @Param: [programId:节目id, xwUserOpenid, commentMain:评论内容]
    * @return: java.util.Map
    * @Author: dong.chao
    * @Date: 2019/4/8
    */
    @RequestMapping("/sendComment")
    public Map sendComment(String programId, String xwUserOpenid,String commentMain){
        Map result = new HashMap<>(2);
        Comment comment = new Comment();
        comment.setProgramId(Integer.parseInt(programId));
        comment.setXwUserOpenid(xwUserOpenid);
        Comment falg = commentService.selectCommentByOpenIdAndProId(comment);
        if(falg != null){
            result.put("status",0);
            result.put("msg","请勿重复评论");
        }else{
            comment.setCommentMain(commentMain);
            commentService.insertComment(comment);
            result.put("status",1);
            result.put("msg","评论成功");
        }
        return result;
    }


    @RequestMapping("/like")
    public Map like(String xwUserOpenid, String programId){
        Map result = new HashMap<>(2);
        Fabulous fabulous = new Fabulous();
        fabulous.setXwUserOpenid(xwUserOpenid);
        fabulous.setProgramId(Integer.parseInt(programId));
        Fabulous falg =  fabulousService.selectFabulousByOpIdAndProId(fabulous);
        if(falg != null){
            fabulousService.deleteFabulousByIds(falg.getFabulousId()+"");
            result.put("status","1");
            result.put("msg","取消成功");
        }else{
            fabulousService.insertFabulous(fabulous);
            result.put("status","1");
            result.put("msg","点赞成功");
        }

        return result;
    }


}
