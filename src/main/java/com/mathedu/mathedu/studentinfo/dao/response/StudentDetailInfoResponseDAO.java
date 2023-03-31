package com.mathedu.mathedu.studentinfo.dao.response;

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
public class StudentDetailInfoResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "처리 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "학생 정보를 조회했습니다.", notes = "처리 상태 메시지", required = true)
    private String message;
    @JsonIgnore
    private HttpStatus code;
    @ApiModelProperty(name = "info", example = "학생 정보 객체", notes = "학생 기본 등록 정보", required = true)
    private StudentDetailInfoDAO info;
}
