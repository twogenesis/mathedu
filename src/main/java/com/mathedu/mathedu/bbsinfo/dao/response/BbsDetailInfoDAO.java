package com.mathedu.mathedu.bbsinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsDetailInfoDAO {
    private Integer no;
    private String category;
    private String title;
    private Date regDt;
    private String contents;
    private Integer authorNo;
    private String authorName;
    private Integer prevNo;
    private String prevTitle;
    private Integer nextNo;
    private String nextTitle;
}
