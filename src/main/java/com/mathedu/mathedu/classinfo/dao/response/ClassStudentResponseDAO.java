package com.mathedu.mathedu.classinfo.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassStudentResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "API 처리 결과 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "담당 반 리스트를 조회했습니다.", notes = "API 처리 결과 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "stuList", notes = "반 학생 리스트 객체")
    private List<ClassStudentDAO> stuList;
    @JsonIgnore
    private HttpStatus code;
}
