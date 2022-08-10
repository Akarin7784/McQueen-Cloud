package org.mcqueen.cloud.admin.gateway.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * 路由信息实体类
 * @author McQueen
 * @version 1.0
 */
@Data
@ToString
@EqualsAndHashCode
@TableName(value = "sys_gateway_route")
public class Route implements Serializable {

    // 主键ID
    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    // 路由名称
    private String routeName;

    // 转发地址
    private String routeUri;

    // 匹配规则
    private String routePredicates;

    // 过滤规则
    private String routeFilter;

    // 创建时间
    private Timestamp createTime;

    // 创建者
    private String creator;

    // 修改时间
    private Timestamp updateTime;

    // 修改者
    private String editor;

    // 备注
    private String remark;

}
