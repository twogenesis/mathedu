package com.mathedu.mathedu.teacherinfo.service;

import com.mathedu.mathedu.teacherinfo.dao.response.TeacherDetailInfoResponseDTO;
import com.mathedu.mathedu.teacherinfo.mapper.TeacherMapper;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherMapper teacherMapper;
    public TeacherDetailInfoResponseDTO getTeacherDetailInfo(String teacherId, Integer page) {
        if(page == null) page = 1;
        return null;
    }
}
