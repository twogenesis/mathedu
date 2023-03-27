package com.mathedu.mathedu.admin.dao.request;

import lombok.Data;

import java.util.Date;

@Data
public class AdminClassInsertDAO {
    private String name;
    private Integer grade;
    private String days;
    private String openDt;
    private String closeDt;
    private String starttime;
    private String endtime;
    private Integer teacherNo;
}
