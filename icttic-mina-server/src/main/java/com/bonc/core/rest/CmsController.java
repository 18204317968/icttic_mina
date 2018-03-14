package com.bonc.core.rest;

import com.bonc.core.service.CmsService;
import com.github.pagehelper.PageInfo;
import com.github.wxiaoqi.security.common.msg.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: ZhangShuo
 * @Description: CMS查询controller
 * @Date: Created in 13:28 2017/11/29
 * @Modified by:
 */

@RestController
@RequestMapping("/api/cms")
public class CmsController {

    @Autowired
    private CmsService cmsService;

    /**
     * 查询cms的节点ID
     *
     * @return
     */
    @GetMapping(value = "/selectCmsNodeId")
    public ObjectRestResponse<List> selectCmsNodeId() {

        List result = cmsService.selectCmsNodeId();

        return new ObjectRestResponse<>().data(result).rel(true).msg("CMS节点ID");
    }

    /**
     * 根据节点ID查询信息摘要
     *
     * @param nodeId
     * @return
     */
    @GetMapping(value = "/selectCmsInfo")
    public ObjectRestResponse<PageInfo<List>> selectCmsInfo(@RequestParam(value = "nodeId") String nodeId, Integer page, Integer size) {

        try {
            PageInfo<List> result = cmsService.selectCmsInfo(nodeId, page, size);
            return new ObjectRestResponse<>().data(result).rel(true).msg("CMS信息摘要");
        } catch (Exception e) {
            e.printStackTrace();
            return new ObjectRestResponse<>().rel(false).msg(e.getMessage());
        }
    }

    /**
     * 根据信息ID查询信息详情
     *
     * @param infoId
     * @return
     */
    @GetMapping(value = "/selectCmsInfoDetail")
    public ObjectRestResponse<List> selectCmsInfoDetail(@RequestParam(value = "infoId") String infoId) {

        try {
            List result = cmsService.selectCmsInfoDetail(infoId);
            return new ObjectRestResponse<>().data(result).rel(true).msg("CMS信息详情");
        } catch (Exception e) {
            e.printStackTrace();
            return new ObjectRestResponse<>().rel(false).msg(e.getMessage());
        }
    }
}
