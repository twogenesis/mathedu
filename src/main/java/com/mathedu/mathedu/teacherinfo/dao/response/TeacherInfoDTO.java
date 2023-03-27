package com.mathedu.mathedu.teacherinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherInfoDTO {
    private Integer no;
    private String id;
    private String imageURL;
    private String status;
    private Date regdt;
    private String name;
}
