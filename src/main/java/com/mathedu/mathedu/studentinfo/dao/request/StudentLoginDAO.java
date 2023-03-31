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
public class StudentLoginDAO {
    @ApiModelProperty(name = "id", example = "true", notes = "학생 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "pwd", example = "true", notes = "학생 비밀번호", required = true)
    private String pwd;
}
