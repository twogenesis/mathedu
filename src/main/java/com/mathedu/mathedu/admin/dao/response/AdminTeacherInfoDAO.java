package com.mathedu.mathedu.admin.dao.response;

import lombok.Data;

import java.util.Date;

@Data
public class AdminTeacherInfoDAO {
    private Integer no;
    private String id;
    private String name;
    private String imageFile;
    private Integer status;
    private Date regDt;
}
