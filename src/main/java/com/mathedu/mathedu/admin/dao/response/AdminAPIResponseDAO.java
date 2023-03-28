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
public class AdminAPIResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "상태 값 (true/false)", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "~ 동작에 성공했습니다.", notes = "요청 결과에 따른 출력 메시지", required = true)
    private String message;
    @JsonIgnore
    private HttpStatus code;
}
