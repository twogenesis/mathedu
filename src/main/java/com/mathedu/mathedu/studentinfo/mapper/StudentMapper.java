package com.mathedu.mathedu.studentinfo.mapper;

import com.mathedu.mathedu.studentinfo.dao.request.StudentInsertDAO;
import com.mathedu.mathedu.studentinfo.dao.request.StudentLoginDAO;
import com.mathedu.mathedu.studentinfo.dao.request.StudentPwdUpdateDAO;
import com.mathedu.mathedu.studentinfo.dao.response.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StudentMapper {
    StudentLoginInfoDAO loginStudent(StudentLoginDAO login);
    void insertStudentInfo(StudentInsertDAO data);
    Boolean isExistStudentId(@Param("id") String id);
    void updateStudentInfo(@Param("id") String id, @Param("data") StudentInsertDAO data);
    void deleteStudentInfo(@Param("id") String id);
    Boolean isValidOldPassword(@Param("id") String id, @Param("pwd") String pwd);
    void updateStudentPassword(@Param("id") String id, @Param("pwd") StudentPwdUpdateDAO pwd);
    StudentRecentScoreDAO getRecentExamScore(@Param("type") String type, @Param("stuId") String stuId);
    StudentBasicInfoDAO getStudentDetailInfo(@Param("stuId") String stuId);
    List<StudentExamTableDataDAO> getStudentTestInfo(
        @Param("stuId") String stuId, @Param("year") Integer year,
        @Param("month") Integer month, @Param("order") String order,
        @Param("type") String type
    );
}
















