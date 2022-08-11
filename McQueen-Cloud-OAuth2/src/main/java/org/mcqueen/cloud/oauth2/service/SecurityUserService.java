package org.mcqueen.cloud.oauth2.service;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.extension.service.IService;
import org.mcqueen.cloud.oauth2.entity.SecurityUser;

public interface SecurityUserService extends IService<SecurityUser> {

    @Override
    default boolean save(SecurityUser entity) {
        entity.setUserRoles(JSON.toJSONString(entity.getAuthorities()));
        return IService.super.save(entity);
    }
}
