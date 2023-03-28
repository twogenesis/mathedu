package com.mathedu.mathedu.bbsinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsFileDetailDTO {
    @ApiModelProperty(name = "fileName", example = "fqweuioyhsdxcyv.pdf", notes = "파일 명", required = true)
    private String fileName;
    @ApiModelProperty(name = "fileType", example = "pdf", notes = "파일 타입", required = true)
    private String fileType;
    @ApiModelProperty(name = "downloadURL", example = "/file/bbs/fqweuioyhsdxcyv.pdf", notes = "파일 URI", required = true)
    private String downloadURL;
}
