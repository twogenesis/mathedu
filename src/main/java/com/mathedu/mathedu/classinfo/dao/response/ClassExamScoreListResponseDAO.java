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
public class ClassExamScoreListResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "처리 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "학생 시험 점수 목록을 조회했습니다.", notes = "처리 상태 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "list", notes = "학생 시험 점수 리스트", required = true)
    private List<ClassExamScoreDAO> list;
    @JsonIgnore
    private HttpStatus code;
}
