package org.mcqueen.cloud.common.response.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

@Data
@Accessors(chain = true)
public class ResponseResult {

    private Integer code;

    private String message;

    private List<?> data;

}
