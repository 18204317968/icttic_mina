package com.bonc.core.rest;

import com.bonc.core.entity.MinaHomeYywd;
import com.bonc.core.service.MinaHomeYywdService;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ZhangShuo
 * @Description:
 * @Date: Created in 17:45 2017/8/15
 * @Modified by:
 */
@RestController
@RequestMapping("/api/update")
public class UpdateYywdNameController {

    @Autowired
    MinaHomeYywdService minaHomeYywdService;

    /**
     * 基于高德地图修改营业网点名字
     *
     * @param provinceCode
     * @param cityName
     * @return
     */
    @GetMapping(value = "/yywdName")
    public ObjectRestResponse<List<MinaHomeYywd>> updateYywdName(@RequestParam(value = "provinceCode") String provinceCode,
                                                                 @RequestParam(value = "cityName") String cityName) {
        int num = minaHomeYywdService.updateYywdName(provinceCode, cityName);
        return new ObjectRestResponse<>().rel(true).msg("成功修改" + num + "条数据");
    }
}
