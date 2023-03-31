package com.mathedu.mathedu.classinfo.dao.response;

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
public class ClassInfoResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "처리 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "반 정보를 조회했습니다.", notes = "처리 상태 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "info", notes = "반 정보 객체", required = true)
    private ClassInfoDAO info;
    @JsonIgnore
    private HttpStatus code;
}
