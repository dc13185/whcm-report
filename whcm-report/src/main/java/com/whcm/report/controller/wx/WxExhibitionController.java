package com.whcm.report.controller.wx;

import com.whcm.report.domain.*;
import com.whcm.report.service.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: dong.chao
 * @create: 2019-04-07 15:27
 * @description: 查询接口
 **/


@RequestMapping("/wx/exhibition")
@RestController
public class WxExhibitionController {

    @Autowired
    private IBannerService bannerServicel;

    @Autowired
    private IProgramService programService;

    @Autowired
    private ITypeService typeService;

    @Autowired
    private ICommentService commentService;

    @Autowired
    private IFabulousService fabulousService;

    @Autowired
    private IVoteService voteService;


        
    /** 
    * @Description: 轮播图接口
    * @Param: [] 
    * @return: java.util.Map 
    * @Author: dong.chao
    * @Date: 2019/4/7 
    */ 
    @RequestMapping("/getBanners")
    public Map getBanners() {
        Map result = new HashMap(1);
        List<Banner> banners =  bannerServicel.selectBannerList(null);
        result.put("result",banners);
        return result;
    }


    /**
     * @Description: 院系接口
     * @Param: []
     * @return: java.util.Map
     * @Author: dong.chao
     * @Date: 2019/4/7
     */
    @RequestMapping("/getTypes")
    public Map getTypes() {
        Map result = new HashMap(1);
        List<Type> types =  typeService.selectTypeList(null);
        result.put("result",types);
        return result;
    }

    /**
    * @Description: 节目接口
    * @Param: [program, status:状态 1：查询点赞数量 0：查询投票数量]
    * @return: java.util.Map
    * @Author: dong.chao
    * @Date: 2019/4/8
    */
    @RequestMapping("/getPrograms")
    public Map getPrograms(Program program,String status) {
        Map result = new HashMap(1);
        List<Program> programs;

        if(StringUtils.equals("0",status)){
            programs  = programService.selectProgramListVotes(program);
        }else{
            programs =  programService.selectProgramList(program);
        }

        programs.forEach(program1 -> {
            if(program1.getIsVote() > 0){
                program1.setFabulous("/images/ico/select_Fabulous.png");
            }
        } );

        result.put("programs",programs);
        return result;
    }
    
    /** 
    * @Description: 获取评论接口
    * @Param: [programId] 
    * @return: java.util.Map 
    * @Author: dong.chao+
    * @Date: 2019/4/8 
    */ 
    @RequestMapping("/getComments")
    public Map getComments(String programId) {
        Map result = new HashMap(1);
        Comment comment = new Comment();
        comment.setProgramId(Integer.parseInt(programId));
        List<Comment> comments = commentService.selectCommentList(comment);
        result.put("comments",comments);
        return  result;
    }

    /**
    * @Description: 获取评论数和点赞数
    * @Param: []
    * @return: java.util.Map
    * @Author: dong.chao
    * @Date: 2019/4/12
    */
    @RequestMapping("/toMyMian")
    public Map toMyMian(String wxUserOpenId){
        Map result = new HashMap(3);
        try {
            int comments =  commentService.selectComments(wxUserOpenId);
            int fabulous = fabulousService.selectFabulousAndVotes(wxUserOpenId);
            result.put("status",'1');
            result.put("comments",comments);
            result.put("fabulous",fabulous);

        }catch (Exception e){
            result.put("status",'0');
            result.put("msg",e.getMessage());
        }

        return result;
    }

    
    /** 
    * @Description: 根据评论id获取到评论的具体内容
    * @Param: [wxUserOpenId] 
    * @return: java.util.Map 
    * @Author: dong.chao
    * @Date: 2019/4/12 
    */ 
    @RequestMapping("/getCommentsByOpenId")
    public Map getCommentsByOpenId(String wxUserOpenId){
        Map result = new HashMap(3);
        try {
            Map comments =  commentService.getCommentsByOpenId(wxUserOpenId);
            result.put("status","1");
            result.put("comments",comments);
        }catch (Exception e){
            result.put("status","0");
            result.put("msg",e.getMessage());
        }
        return result;
    }

    /** 
    * @Description: 根据点赞或投票id获取到具体内容
    * @Param: [fabulouId] 
    * @return: java.util.Map 
    * @Author: dong.chao
    * @Date: 2019/4/12 
    */ 
    @RequestMapping("/getFabulousByOpenId")
    public Map getFabulousByOpenId(String wxUserOpenId){
        Map result = new HashMap(3);
        try {
            List<HashMap> fabulouMap = fabulousService.getFabulousByOpenId(wxUserOpenId);
            List<HashMap> votes =   voteService.getVotesByOpenId(wxUserOpenId);
            result.put("votes",votes);
            result.put("fabulous",fabulouMap);
            result.put("status","1");
        }catch (Exception e){
            result.put("status","0");
            result.put("msg",e.getMessage());
        }
        return result;
    }



}
