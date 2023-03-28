package com.mathedu.mathedu.admin.dao.response;

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
public class AdminTeacherListResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "선생님 목록을 조회했습니다.", notes = "", required = true)
    private String message;
    @ApiModelProperty(name = "list", notes = "선생님 정보 리스트", required = true)
    private List<AdminTeacherInfoDAO> list;
    @ApiModelProperty(name = "totalCount", example = "11", notes = "총 데이터 수", required = true)
    private Integer totalCount;
    @ApiModelProperty(name = "totalPage", example = "2", notes = "총 페이지 수", required = true)
    private Integer totalPage;
    @ApiModelProperty(name = "currentPage", example = "1", notes = "현재 페이지", required = true)
    private Integer currentPage;
    @ApiModelProperty(name = "keyword", example = "검색어", notes = "검색어", required = true)
    private String keyword;
    @JsonIgnore
    private HttpStatus code;
}
