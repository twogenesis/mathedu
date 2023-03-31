package com.mathedu.mathedu.studentinfo.dao.response;


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
public class StudentLoginResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "처리 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "정상적으로 로그인 되었습니다.", notes = "상테 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "login", notes = "로그인 학생 정보", required = true)
    private StudentLoginInfoDAO login;
    private HttpStatus code;
}
