package com.mathedu.mathedu.bbsinfo.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsInfoDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "글 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "title", example = "자료실 글 제목", notes = "글 제목", required = true)
    private String title;
    @ApiModelProperty(name = "content", example = "자료실 글 내용", notes = "글 내용", required = true)
    private String content;
    @ApiModelProperty(name = "teacherNo", example = "1", notes = "선생님 DB상의 시퀀스 번호", required = true)
    private Integer teacherNo;
    @ApiModelProperty(name = "classNo", example = "1", notes = "반 DB상의 시퀀스 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "category", example = "수업자료", notes = "카테고리 명", required = true)
    private String category;
}
