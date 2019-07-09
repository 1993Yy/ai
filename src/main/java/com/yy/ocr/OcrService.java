package com.yy.ocr;

import cn.hutool.core.codec.Base64;
import cn.hutool.http.HttpUtil;
import com.yy.entity.Account;
import com.yy.util.SignUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @Package: com.yy.ocr
 * @ClassName: OcrService
 * @Author: Created By Yy
 * @Date: 2019-07-03 17:53
 */
@Service
public class OcrService {

    @Autowired
    Account account;

    /**
     * 身份证
     * @param card_type 0-正面 1-反面
     * @param inputStream
     * @return
     */
    public String idcard(Integer card_type, InputStream inputStream){
        if (Objects.isNull(card_type) || !Arrays.asList(0,1).contains(card_type)){
            card_type=0;
        }
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("card_type",card_type);
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.idcardUrl, map);
        return data;
    }

    /**
     *  驾驶证，行驶证
     * @param type 0-行驶证识别，1-驾驶证识别
     * @param inputStream
     * @return
     */
    public String driver(Integer type,InputStream inputStream){
        if (Objects.isNull(type) || !Arrays.asList(0,1).contains(type)){
            type=0;
        }
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("type",type);
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.driverUrl, map);
        return data;
    }
    /**
     *  通用
     * @param inputStream
     * @return
     */
    public String general(InputStream inputStream){
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.generalUrl, map);
        return data;
    }
    /**
     *  营业执照
     * @param inputStream
     * @return
     */
    public String biz(InputStream inputStream){
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.bizUrl, map);
        return data;
    }
    /**
     *  银行卡
     * @param inputStream
     * @return
     */
    public String creditcard(InputStream inputStream){
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.creditcardUrl, map);
        return data;
    }
    /**
     *  手写体
     * @param inputStream
     * @return
     */
    public String handwriting(InputStream inputStream){
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.handwritingUrl, map);
        return data;
    }
    /**
     *  车牌
     * @param inputStream
     * @return
     */
    public String plate(InputStream inputStream){
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.plateUrl, map);
        return data;
    }
    /**
     *  名片
     * @param inputStream
     * @return
     */
    public String bc(InputStream inputStream){
        String image = Base64.encode(inputStream);
        Map<String,Object> params=new HashMap<>();
        params.put("image",image);
        Map<String, Object> map = SignUtil.getSign(account,params, null);
        String data = HttpUtil.post(OcrUrl.bcUrl, map);
        return data;
    }


}
