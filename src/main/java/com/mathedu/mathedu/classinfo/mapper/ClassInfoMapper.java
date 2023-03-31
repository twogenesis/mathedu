package com.mathedu.mathedu.classinfo.mapper;

import com.mathedu.mathedu.classinfo.dao.response.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ClassInfoMapper {
    Integer getClassCountByTeacherNo(@Param("teacherNo") Integer teacherNo);
    List<ClassSummaryInfoDAO> getClassListByTeacherNo(
            @Param("teacherNo") Integer teacherNo, @Param("keyword") String keyword, @Param("offset") Integer offset
    );
    ClassInfoDAO getClassInfo(@Param("classNo") Integer classNo);

    List<ClassStudentDAO> getClassStudentList(@Param("classNo") Integer classNo);
    void insertStudentExamScore(@Param("examNo") Integer examNo, @Param("studentId") String studentId, @Param("score") Integer score);
    Boolean isExistExamScore(@Param("examNo") Integer examNo, @Param("studentId") String studentId);
    void updateStudentExamScore(@Param("examNo") Integer examNo, @Param("studentId") String studentId, @Param("score") Integer score);

    List<ClassExamScoreDAO> getExamScoreList(@Param("examNo") Integer examNo, @Param("sort") String sort, @Param("order") String order);
    ClassExamStudentTinyInfoDAO getMaxScoreStudent(@Param("examNo") Integer examNo);
    ClassExamStudentTinyInfoDAO getMinScoreStudent(@Param("examNo") Integer examNo);
    Integer getExamAverageScore(@Param("examNo") Integer examNo);
    List<Integer> getScoreAreaData(@Param("examNo") Integer examNo);
}
