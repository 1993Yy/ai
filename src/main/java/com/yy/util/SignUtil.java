package com.yy.util;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.SecureUtil;
import com.yy.entity.Account;

import java.net.URLEncoder;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * @Package: com.yy.util
 * @ClassName: SignUtil
 * @Author: Created By Yy
 * @Date: 2019-07-03 17:36
 */

public class SignUtil {

    public static Map<String,Object> getSign(Map<String, Object> params, String charset){
        final String charset1;
        if (Objects.isNull(charset)){
            charset1="UTF-8";
        }else {
            charset1=charset;
        }
        Account account=new Account();
        account.setAppId(2118147806);
        account.setAppKey("AssxqFKVramn45g5");
        Map<String,Object> param=new TreeMap<>(params);
        param.put("app_id",account.getAppId());
        param.put("time_stamp", DateUtil.currentSeconds());
        param.put("nonce_str", IdUtil.simpleUUID());
        StringBuilder builder=new StringBuilder();
        param.forEach((k,v)->{
            try {
                builder.append(k).append("=");
                builder.append(URLEncoder.encode(String.valueOf(v),charset1)).append("&");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        builder.append("app_key=").append(account.getAppKey());
        String sign = SecureUtil.md5(builder.toString()).toUpperCase();
        param.put("sign",sign);
        return param;
    }
}
