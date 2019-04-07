package com.whcm.report.controller.wx;

import com.whcm.report.domain.Banner;
import com.whcm.report.domain.Program;
import com.whcm.report.domain.Type;
import com.whcm.report.service.IBannerService;
import com.whcm.report.service.IProgramService;
import com.whcm.report.service.ITypeService;
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
        result.put("result",programs);
        return result;
    }






}
