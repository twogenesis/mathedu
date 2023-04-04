package com.mathedu.mathedu.noticeinfo.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeDetailResponseDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "글 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "classNo", example = "1", notes = "반 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "category", example = "수업자료", notes = "글 카테고리", required = true)
    private String category;
    @ApiModelProperty(name = "title", example = "샘플 타이틀", notes = "글 제목", required = true)
    private String title;
    @ApiModelProperty(name = "regDt", example = "2023-03-05 00:00:00", notes = "등록 시간", required = true)
    private Date regDt;
    @ApiModelProperty(name = "contents", example = "샘플 글 내용", notes = "글 내용", required = true)
    private String contents;
    @ApiModelProperty(name = "authorNo", example = "1", notes = "작성자 DB상의 시퀀스 번호", required = true)
    private Integer authorNo;
    @ApiModelProperty(name = "authorName", example = "선생님", notes = "작성자 명", required = true)
    private String authorName;
    @ApiModelProperty(name = "files", notes = "글에 등록된 파일 목록", required = true)
    private List<NoticeFileDetailDAO> files;
    @ApiModelProperty(name = "prevPost", example = "이전 글 간략 정보", notes = "이전 글 정보 (null일 경우 정보 없음)", required = false)
    private NoticeTinyInfo prevPost;
    @ApiModelProperty(name = "nextPost", example = "다음 글 간략 정보", notes = "다음 글 정보 (null일 경우 정보 없음)", required = false)
    private NoticeTinyInfo nextPost;
    @JsonIgnore
    private HttpStatus code;
}
