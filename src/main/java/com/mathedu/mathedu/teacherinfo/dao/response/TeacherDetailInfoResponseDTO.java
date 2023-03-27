package com.mathedu.mathedu.teacherinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class TeacherDetailInfoResponseDTO {
    private String id;
    private String name;
    private String imageURL;
    private String status;
    private Date regdt;
    private List<TeacherStudentInfoDTO> stuList;

}
