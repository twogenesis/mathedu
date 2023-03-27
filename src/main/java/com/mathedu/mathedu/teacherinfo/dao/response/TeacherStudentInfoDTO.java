package com.mathedu.mathedu.teacherinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherStudentInfoDTO {
    private String no;
    private String img;
    private String name;
    private String phone;
    private String alternatephone;
    private String address;
}
