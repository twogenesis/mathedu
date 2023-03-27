package com.mathedu.mathedu.bbsinfo.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class BbsDetailResponseDAO {
    private Integer no;
    private String category;
    private String title;
    private Date regDt;
    private String contents;
    private Integer authorNo;
    private String authorName;
    private List<BbsFileDetailDTO> files;
    private BbsTinyInfo prevPost;
    private BbsTinyInfo nextPost;
    @JsonIgnore
    private HttpStatus code;
}
