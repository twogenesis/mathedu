package com.mathedu.mathedu.admin.dao.response;

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
public class AdminClassListResponseDAO {
    @ApiModelProperty(name = "currentPage", example = "1", notes = "현재 페이지 번호", required = true)
    private Integer currentPage;
    @ApiModelProperty(name = "pageCount", example = "10", notes = "전체 페이지 수", required = true)
    private Integer pageCount;
    @ApiModelProperty(name = "totalCount", example = "98", notes = "전체 데이터 수", required = true)
    private Integer totalCount;
    @ApiModelProperty(name = "list", notes = "반 정보 요약 리스트", required = true)
    private List<AdminClassSummaryInfoDAO> list;
}
