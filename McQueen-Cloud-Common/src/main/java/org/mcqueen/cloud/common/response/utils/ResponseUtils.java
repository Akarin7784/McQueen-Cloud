package org.mcqueen.cloud.common.response.utils;

import com.alibaba.fastjson2.JSONObject;
import org.mcqueen.cloud.common.response.entity.ResponseResult;

import java.util.List;

/**
 * 响应处理工具类
 * @author McQueen
 * @version 1.0
 */
public class ResponseUtils {

    private ResponseUtils(){

    }

    public static String buildSuccessResultOnlyMessage(String message){
        return JSONObject.toJSONString(
                new ResponseResult()
                        .setCode(200)
                        .setMessage(message)
        );
    }

    public static String buildSuccessResultWithArrayData(String message, List<?> data){
        return JSONObject.toJSONString(
                new ResponseResult()
                        .setCode(200)
                        .setMessage(message)
                        .setData(data)
        );
    }

    public static String buildFailedResultOnlyMessage(String message){
        return JSONObject.toJSONString(
                new ResponseResult()
                        .setMessage(message)
                        .setCode(500)
        );
    }
}
