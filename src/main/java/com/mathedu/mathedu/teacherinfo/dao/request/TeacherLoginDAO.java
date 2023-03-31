package com.mathedu.mathedu.teacherinfo.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherLoginDAO {
    private String id;
    private String pwd;
}
