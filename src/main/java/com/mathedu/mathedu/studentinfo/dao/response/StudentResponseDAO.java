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
public class StudentResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "처리 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "학생정보 (등록/수정/삭제)에 성공했습니다.", notes = "상테 메시지", required = true)
    private String message;
    @JsonIgnore
    private HttpStatus code;
}
