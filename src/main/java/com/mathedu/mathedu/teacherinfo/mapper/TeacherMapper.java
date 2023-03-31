package com.mathedu.mathedu.teacherinfo.mapper;

import com.mathedu.mathedu.teacherinfo.dao.request.TeacherLoginDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherClassTinyInfoDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherInfoDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherStudentInfoDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherSummaryDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TeacherMapper {
    TeacherInfoDAO findTeacherInfoById(@Param("teacherId") String teacherId);
    List<TeacherStudentInfoDAO> getStudentListByTeacherNo(@Param("no") Integer no, @Param("offset") Integer offset);
    Integer getStudentCountByTeacherNo(@Param("no") Integer no);
    TeacherSummaryDAO loginTeacher(TeacherLoginDAO login);

    List<TeacherClassTinyInfoDAO> getTeacherClassList(@Param("teacherId") String teacherId);
}
