package com.github.wxiaoqi.security.common.exception.auth;


import com.github.wxiaoqi.security.common.constant.RestCodeConstants;
import com.github.wxiaoqi.security.common.exception.BaseException;

/**
 * Created by ace on 2017/9/8.
 */
public class InvalidKeyException extends BaseException {
    public InvalidKeyException(String message) {
        super(message, RestCodeConstants.KEY_ERROR_CODE);
    }
}
