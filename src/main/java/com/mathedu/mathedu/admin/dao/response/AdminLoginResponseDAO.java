package com.mathedu.mathedu.admin.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminLoginResponseDAO {
    @ApiModelProperty(name = "response", notes = "처리 상태 응답 객체", required = true)
    private AdminAPIResponseDAO response;
    @ApiModelProperty(name = "id", example = "adminuser001", notes = "관리자 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "status", example = "2", notes = "관리자 상태 값", required = true)
    private Integer status;
}
