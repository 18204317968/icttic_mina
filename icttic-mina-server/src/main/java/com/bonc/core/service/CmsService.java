package com.bonc.core.service;

import com.bonc.core.mapper.MinaBuslinesMapper;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: ZhangShuo
 * @Description: CMS Service
 * 借用的buslinemapper写的sql 没有实体类映射
 * @Date: Created in 12:17 2017/11/29
 * @Modified by:
 */

@Service
public class CmsService {

    //此处是借用的buslinemapper写的sql 没有实体类映射
    @Autowired
    private MinaBuslinesMapper minaBuslinesMapper;

    public List selectCmsNodeId() {
        List result = minaBuslinesMapper.selectCmsNodeId();
        return result;
    }

    public PageInfo<List> selectCmsInfo(String nodeId, Integer page, Integer size) {
        PageHelper.startPage(page == null ? 1 : page, size == null ? 10 : size, false);
        List result = minaBuslinesMapper.selectCmsInfo(nodeId);
        PageInfo<List> pageInfo = new PageInfo<>(result);
        return pageInfo;
    }

    public List selectCmsInfoDetail(String infoId) {
        List result = minaBuslinesMapper.selectCmsInfoDetail(infoId);
        return result;
    }
}
