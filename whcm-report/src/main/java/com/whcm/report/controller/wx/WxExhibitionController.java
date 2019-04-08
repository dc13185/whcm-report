package com.whcm.report.controller.wx;

import com.whcm.report.domain.*;
import com.whcm.report.service.*;
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

@RestController
@RequestMapping("/wx/exhibition")
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
     * @Param: []
     * @return: java.util.Map
     * @Author: dong.chao
     * @Date: 2019/4/7
     */
    @RequestMapping("/getPrograms")
    public Map getPrograms(Program program) {
        Map result = new HashMap(1);
        List<Program> programs =  programService.selectProgramList(program);

        Comment comment = new Comment();
        comment.setProgramId(program.getProgramId());
        List<Comment> comments = commentService.selectCommentList(comment);

        Integer fabulous = fabulousService.selectFabulousByProId(program.getProgramId());

        result.put("programs",programs);
        result.put("comments",comments);
        result.put("fabulous",fabulous);
        return result;
    }






}
