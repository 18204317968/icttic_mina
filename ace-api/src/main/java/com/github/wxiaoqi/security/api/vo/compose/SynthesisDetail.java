package com.github.wxiaoqi.security.api.vo.compose;


import java.util.List;

/**
 * Created by yanqi on 2017/9/13.
 */
public class SynthesisDetail extends THcPoliceWarn {

    private List<THcInfoFeedBack> feedBackList;


    public List<THcInfoFeedBack> getFeedBackList() {
        return feedBackList;
    }

    public void setFeedBackList(List<THcInfoFeedBack> feedBackList) {
        this.feedBackList = feedBackList;
    }
}
