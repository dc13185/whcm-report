package com.whcm.report.controller.wx;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.whcm.report.domain.Comment;
import com.whcm.report.domain.Fabulous;
import com.whcm.report.domain.Type;
import com.whcm.report.domain.Vote;
import com.whcm.report.service.ICommentService;
import com.whcm.report.service.IFabulousService;
import com.whcm.report.service.ITypeService;
import com.whcm.report.service.IVoteService;
import com.whcm.report.websocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * @author: dong.chao
 * @create: 2019-04-07 16:26
 * @description: 评论点赞接口
 **/


@RestController
@RequestMapping("/wx/comment")
public class WxCommentController {

    /** 最大投票值 */
    private static  int COUNT = 3;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IFabulousService fabulousService;

    @Autowired
    private IVoteService voteService;

    @Autowired
    private ITypeService typeService;

    /**
    * @Description: 评论接口
    * @Param: [programId:节目id, xwUserOpenid, commentMain:评论内容]
    * @return: java.util.Map
    * @Author: dong.chao
    * @Date: 2019/4/8
    */
    @RequestMapping("/sendComment")
    public Map sendComment( String programId, String xwUserOpenid, String commentMain){
        Map result = new HashMap<>(2);
        Comment comment = new Comment();
        comment.setProgramId(Integer.parseInt(programId));
        comment.setXwUserOpenid(xwUserOpenid);
       /* Comment falg = commentService.selectCommentByOpenIdAndProId(comment);
       *  if(falg != null){
            result.put("status",0);
            result.put("msg","请勿重复评论");
        }else{
        *  }
       * */
        comment.setCommentMain(commentMain);
        commentService.insertComment(comment);
        result.put("status",1);

        return result;
    }

    /**
    * @Description: 点赞
    * @Param: [xwUserOpenid, programId:节目id]
    * @return: java.util.Map
    * @Author: dong.chao
    * @Date: 2019/4/8
    */
    @RequestMapping("/like")
    public Map like( String xwUserOpenid, String programId){
        Map result = new HashMap<>(2);
        Fabulous fabulous = new Fabulous();
        fabulous.setXwUserOpenid(xwUserOpenid);
        fabulous.setProgramId(Integer.parseInt(programId));
        synchronized(xwUserOpenid.intern()) {
            Fabulous falg = fabulousService.selectFabulousByOpIdAndProId(fabulous);
            if (falg != null) {
                fabulousService.deleteFabulousByIds(falg.getFabulousId() + "");
                result.put("status", "1");
                result.put("msg", "取消成功");
            } else {
                fabulousService.insertFabulous(fabulous);
                result.put("status", "1");
                result.put("msg", "点赞成功");
            }

            return result;
        }
    }


    /**
     * @Description: 投票（同一个人只能投三票）
     * @Param: [xwUserOpenid, programId:节目id]
     * @return: java.util.Map
     * @Author: dong.chao
     * @Date: 2019/4/8
     */
    @RequestMapping("/vote")
    public Map vote( String xwUserOpenid, String programId){
        Map result = new HashMap<>(2);
        Vote vote = new Vote();

        vote.setXwUserOpenid(xwUserOpenid);
        vote.setProgramId(Integer.parseInt(programId));
        Type type = typeService.selectTypeByProId(vote.getProgramId());
        vote.setTypeId(type.getTypeId());

        synchronized(xwUserOpenid.intern()){
            if(type.getIsComment() == 1){
                Vote falg = voteService.selectVoteById(vote);
                if(falg != null){
                    //已经投票过了
                    result.put("stat0us",0);
                    result.put("msg","请勿重复投票");
                }else{
                    voteService.insertVote(vote);
                    List<Object> votes = voteService.selectAllVotes();
                    String sendMassage = JSONObject.toJSONString(votes);
                    WebSocketServer.sendInfo(sendMassage);
                    result.put("status",1);
                    result.put("msg","投票成功");
                }
            }else{
                result.put("status",0);
                result.put("msg","投票尚未开始");
            }

            return result;
        }

    }

    @RequestMapping("/voteTest")
    public Map voteTest(){
        String xwUserOpenid = UUID.randomUUID().toString();
        int programIds[] ={110 ,112 ,113,132};
        Random random = new Random();

        Map result = new HashMap<>(2);
        Vote vote = new Vote();

        vote.setXwUserOpenid(xwUserOpenid);
        vote.setProgramId(programIds[random.nextInt(4)]);
        Type type = typeService.selectTypeByProId(vote.getProgramId());
        vote.setTypeId(type.getTypeId());

        synchronized(xwUserOpenid.intern()){
            if(type.getIsComment() == 1){
                Vote falg = voteService.selectVoteById(vote);
                if(falg != null){
                    //已经投票过了
                    result.put("stat0us",0);
                    result.put("msg","请勿重复投票");
                }else{
                    voteService.insertVote(vote);
                    List<Object> votes = voteService.selectAllVotes();
                    String sendMassage = JSONObject.toJSONString(votes);
                    WebSocketServer.sendInfo(sendMassage);
                    result.put("status",1);
                    result.put("msg","投票成功");
                }
            }else{
                result.put("status",0);
                result.put("msg","投票尚未开始");
            }

            return result;
        }

    }


    @RequestMapping("/editTypeStatus")
    public Map editTypeStatus(String typeId,String status){
        Map result = new HashMap<>(2);

        Type type = new Type();
        type.setTypeId(Integer.parseInt(typeId));
        type.setIsComment(Integer.parseInt(status));
        try {
            typeService.updateType(type);
            result.put("status",1);
        }catch (Exception e){
            result.put("status",0);
            result.put("msg",e.getMessage());
        }

        return result ;
    }




}
