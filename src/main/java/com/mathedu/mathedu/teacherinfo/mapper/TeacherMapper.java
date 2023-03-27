package com.mathedu.mathedu.teacherinfo.mapper;

import com.mathedu.mathedu.teacherinfo.dao.response.TeacherInfoDTO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherStudentInfoDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherInfoDTO findTeacherInfoById(@Param("teacherId") String teacherId);
    List<TeacherStudentInfoDTO> getStudentListByTeacherNo(@Param("no") Integer no, @Param("offset") Integer offset);
}
