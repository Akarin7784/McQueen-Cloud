package org.mcqueen.cloud.admin.gateway.controller;

import com.alibaba.fastjson2.JSON;
import com.mysql.cj.util.StringUtils;
import org.mcqueen.cloud.admin.gateway.entity.Route;
import org.mcqueen.cloud.admin.gateway.service.RouteService;
import org.mcqueen.cloud.common.response.utils.ResponseUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Gateway 网关管理控制器
 * @author McQueen
 * @version 1.0
 */
@RestController
@RequestMapping("/gateway")
public class GatewayController {

    @Resource
    private RouteService routeService;

    /**
     * 查询所有网关信息
     * @return String JSON格式的网关信息
     */
    @GetMapping("/list")
    public String list(){
        List<Route> list = routeService.list();
        return ResponseUtils.buildSuccessResultWithArrayData("请求成功",list);
    }

    /**
     * 添加网关信息
     * @return String JSON格式的网关信息
     */
    @PostMapping("/add")
    public String add(String message){
        // 将数据转为Route集合
        List<Route> routes;
        try{
            if (!StringUtils.isNullOrEmpty(message)){
                routes = JSON.parseArray(message, Route.class);
            }else {
                throw new NullPointerException();
            }
        }catch (Exception e){
            e.printStackTrace();
            return ResponseUtils.buildFailedResultOnlyMessage("数据有错误");
        }
        // 便利routes集合，将路由信息存入数据库
        AtomicInteger successCount = new AtomicInteger();
        routes.forEach((route -> {
            if (routeService.save(route)) {
                successCount.getAndIncrement();
            }
        }));
        // 返回成功信息
        return ResponseUtils.buildSuccessResultOnlyMessage(
                "成功添加了" +successCount +"条记录,失败了" + (routes.size() - successCount.intValue()) + "条记录。"
        );
    }

    /**
     *
     *
     * 根据ID删除网关信息
     * @return String JSON格式的网关信息
     */
    @PostMapping("/deleteById")
    public String delete(@RequestBody HashMap<String,Object> data){
        return null;
    }

    /**
     * 根据ID修改网关信息
     * @return String JSON格式的网关信息
     */
    @PostMapping("/updateById")
    public String updateById(@RequestBody HashMap<String,Object> date){
        return null;
    }

}