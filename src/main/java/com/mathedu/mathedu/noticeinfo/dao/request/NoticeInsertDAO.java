package com.mathedu.mathedu.noticeinfo.dao.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeInsertDAO {
    @ApiModelProperty(name = "title", example = "Sample Title", notes = "글 제목", required = true)
    private String title;
    @ApiModelProperty(name = "category", example = "수업자료", notes = "카테고리", required = true)
    private String category;
    @ApiModelProperty(name = "content", example = "글의 내용입니다.", notes = "글 내용", required = true)
    private String content;
    @ApiModelProperty(name = "teacherNo", example = "1", notes = "선생님 DB상의 시퀀스 번호", required = true)
    private Integer teacherNo;
    @ApiModelProperty(name = "classNo", example = "1", notes = "반 DB상의 시퀀스 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "files", notes = "파일 객체 배열", required = false)
    private MultipartFile[] files;
}
