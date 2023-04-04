package com.mathedu.mathedu.examinfo.dao.response;

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
public class ExamScoreListInfoResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "처리 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "정상 처리 되었습니다.", notes = "처리 상태 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "currentPage", example = "1", notes = "현재 페이지", required = true)
    private Integer currentPage;
    @ApiModelProperty(name = "totalPage", example = "5", notes = "전체 페이지", required = true)
    private Integer totalPage;
    @ApiModelProperty(name = "totalCount", example = "53", notes = "전체 학생 점수 수", required = true)
    private Integer totalCount;
    @ApiModelProperty(name = "list", notes = "학생 점수 리스트", required = true)
    private List<ExamScoreInfoDAO> list;
    @JsonIgnore
    private HttpStatus code;
}
