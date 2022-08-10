package org.mcqueen.cloud.admin.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mcqueen.cloud.admin.gateway.entity.Route;
import org.mcqueen.cloud.admin.gateway.mapper.RouteMapper;
import org.mcqueen.cloud.admin.gateway.service.RouteService;
import org.springframework.stereotype.Service;

@Service
public class RouteServiceImpl extends ServiceImpl<RouteMapper, Route> implements RouteService {
}
