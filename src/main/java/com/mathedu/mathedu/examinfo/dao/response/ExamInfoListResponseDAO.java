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
public class ExamInfoListResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "처리 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "정상 처리 되었습니다.", notes = "처리 상태 메시지", required = true)
    private String message;
    private Integer totalCount;
    private Integer totalPage;
    private Integer currentPage;
    private List<ExamInfoDAO> list;
    @JsonIgnore
    private HttpStatus code;
}
