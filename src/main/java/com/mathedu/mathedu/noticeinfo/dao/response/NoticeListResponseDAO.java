package com.mathedu.mathedu.noticeinfo.dao.response;

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
public class NoticeListResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "totalPage", example = "5", notes = "총 페이지", required = true)
    private Integer totalPage;
    @ApiModelProperty(name = "currentPage", example = "1", notes = "현재 페이지", required = true)
    private Integer currentPage;
    @ApiModelProperty(name = "totalCount", example = "43", notes = "총 글의 수", required = true)
    private Integer totalCount;
    @ApiModelProperty(name = "keyword", example = "검색어", notes = "검색어", required = true)
    private String keyword;
    @ApiModelProperty(name = "list", notes = "글 요약정보 리스트", required = true)
    private List<NoticeSummaryDAO> list;
    @JsonIgnore
    private HttpStatus code;
}
