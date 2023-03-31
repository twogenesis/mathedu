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
public class StudentWeekMonthExamResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "학생의 주간/월간 시험 정보를 조회했습니다.", notes = "상태 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "data", notes = "주간/월간 시험정보 객체", required = true)
    private StudentWeekMonthExamDAO data;
    @JsonIgnore
    private HttpStatus code;
}
