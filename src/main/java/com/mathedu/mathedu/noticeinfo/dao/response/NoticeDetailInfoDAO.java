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
public class NoticeDetailInfoDAO {
    @ApiModelProperty(name = "no", example = "3", notes = "글 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "classNo", example = "1", notes = "반 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "category", example = "수업자료", notes = "글 카테고리", required = true)
    private String category;
    @ApiModelProperty(name = "title", example = "Sample Title", notes = "글 제목", required = true)
    private String title;
    @ApiModelProperty(name = "regDt", example = "2021-03-05 00:00:00", notes = "등록 시간", required = true)
    private Date regDt;
    @ApiModelProperty(name = "contents", example = "글의 내용 부분", notes = "글의 내용", required = true)
    private String contents;
    @ApiModelProperty(name = "authorNo", example = "1", notes = "작성자의 DB상의 시퀀스 번호", required = true)
    private Integer authorNo;
    @ApiModelProperty(name = "authorName", example = "선생님", notes = "작성자 이름", required = true)
    private String authorName;
    @ApiModelProperty(name = "prevNo", example = "2", notes = "이전 글 번호", required = true)
    private Integer prevNo;
    @ApiModelProperty(name = "prevTitle", example = "Previous Post Title", notes = "이전 글 제목", required = true)
    private String prevTitle;
    @ApiModelProperty(name = "nextNo", example = "4", notes = "다음 글 번호", required = true)
    private Integer nextNo;
    @ApiModelProperty(name = "nextTitle", example = "Next Post Title", notes = "다음 글 제목", required = true)
    private String nextTitle;
}
