package com.mathedu.mathedu.admin.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminClassSummaryInfoDAO {
    private Integer seq;
    private String title;
    private String days;
    private Integer grade;
    private String teacher;
    private Integer studentCnt;
    private Date opendt;
    private Date closedt;
}
