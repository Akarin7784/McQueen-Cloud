package org.mcqueen.cloud.oauth2.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.mcqueen.cloud.oauth2.entity.SecurityUser;
import org.mcqueen.cloud.oauth2.mapper.SecurityUserMapper;
import org.mcqueen.cloud.oauth2.service.SecurityUserService;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserServiceImpl extends ServiceImpl<SecurityUserMapper, SecurityUser> implements SecurityUserService {
}
