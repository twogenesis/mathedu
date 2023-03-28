package com.mathedu.mathedu.noticeinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeTinyInfo {
    @ApiModelProperty(name = "no", example = "1", notes = "글 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "title", example = "샘플 글 제목", notes = "글 제목", required = true)
    private String title;
}
