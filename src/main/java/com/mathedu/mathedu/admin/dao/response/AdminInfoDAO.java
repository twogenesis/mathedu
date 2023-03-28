package com.mathedu.mathedu.admin.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class AdminInfoDAO {
    @ApiModelProperty(name = "id", example = "adminuser001", notes = "관리자 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "status", example = "1", notes = "관리자 상태 값", required = true)
    private Integer status;
}
