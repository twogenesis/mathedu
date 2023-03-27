package com.mathedu.mathedu.bbsinfo.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsInfoDAO {
    private Integer no;
    private String title;
    private String content;
    private Integer teacherNo;
    private Integer classNo;
}
