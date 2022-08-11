package org.mcqueen.cloud.oauth2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mcqueen.cloud.oauth2.entity.SecurityUser;

@Mapper
public interface SecurityUserMapper extends BaseMapper<SecurityUser> {
}
