package com.mathedu.mathedu.studentinfo.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentPwdUpdateDAO {
    @ApiModelProperty(name = "oldPwd", example = "1234", notes = "학생 기존 비밀번호", required = true)
    private String oldPwd;
    @ApiModelProperty(name = "newPwd", example = "123456", notes = "학생 새 비밀번호", required = true)
    private String newPwd;
}
