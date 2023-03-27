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

public class AdminClassInfoDAO {
    private Integer no;
    private String title;
    private String days;
    private Integer grade;
    private Integer teacher;
    private Integer studentCnt;
    private Date opendt;
    private Date closedt;
}
