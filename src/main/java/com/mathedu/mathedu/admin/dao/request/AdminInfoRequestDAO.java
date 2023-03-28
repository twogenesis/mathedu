package com.mathedu.mathedu.admin.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminInfoRequestDAO {
    @ApiModelProperty(name = "id", example = "adminuser001", notes = "관리자 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "pwd", example = "1234", notes = "관리자 비밀번호", required = true)
    private String pwd;
}
