package com.mathedu.mathedu.noticeinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeSummaryDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "글 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "category", example = "수업자료", notes = "글 카테고리", required = true)
    private String category;
    @ApiModelProperty(name = "title", example = "수업 자료 업로드 2023-03-01", notes = "글 제목", required = true)
    private String title;
    @ApiModelProperty(name = "regDt", example = "2023-03-01 18:53:23", notes = "등록 시간", required = true)
    private Date regDt;
    @ApiModelProperty(name = "authorNo", example = "1", notes = "작성자 DB상의 시퀀스 번호", required = true)
    private Integer authorNo;
    @ApiModelProperty(name = "authorName", example = "선생님", notes = "작성자 명", required = true)
    private String authorName;
}
