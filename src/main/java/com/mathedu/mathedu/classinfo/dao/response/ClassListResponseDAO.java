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
public class ClassListResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "API 처리 결과 상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "담당 반 리스트를 조회했습니다.", notes = "API 처리 결과 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "totalPage", example = "2", notes = "총 페이지 수", required = true)
    private Integer totalPage;
    @ApiModelProperty(name = "currentPage", example = "1", notes = "현재페이지")
    private Integer currentPage;
    @ApiModelProperty(name = "totalCount", example = "12", notes = "총 담당 반 수", required = true)
    private Integer totalCount;
    @ApiModelProperty(name = "keyword", example = "기초", notes = "검색어")
    private String keyword;
    @ApiModelProperty(name = "list", notes = "반 요약 정보 리스트 객체")
    private List<ClassSummaryInfoDAO> list;
    @JsonIgnore
    private HttpStatus code;
}
