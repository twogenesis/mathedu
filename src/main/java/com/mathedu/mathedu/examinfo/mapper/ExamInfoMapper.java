package com.mathedu.mathedu.examinfo.mapper;

import com.mathedu.mathedu.examinfo.dao.request.ExamInfoInsertDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamInfoDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamInfoSummaryDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamScoreDataDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamScoreInfoDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ExamInfoMapper {
    void insertExamInfo(ExamInfoInsertDAO data);
    Boolean isExistExamInfo(@Param("examNo") Integer examNo);

    void updateExamInfo(@Param("examNo") Integer examNo, @Param("data") ExamInfoInsertDAO data);
//    List<ExamScoreInfoDAO> getExamScoreList(@Param("examNo") Integer examNo, @Param("offset") Integer offset);
//    Integer getExamScoreListCount(@Param("examNo") Integer examNo);
    List<ExamInfoDAO> getExamList(
            @Param("examType") String examType, @Param("classNo") Integer classNo, @Param("offset") Integer offset,
            @Param("keyword") String keyword, @Param("orderType") String orderType, @Param("order") String order
    );
    Integer getExamListCount(@Param("examType") String examType, @Param("classNo") Integer classNo, @Param("keyword") String keyword);

    List<ExamScoreInfoDAO> getExamScoreStudentList(@Param("classNo") Integer classNo, @Param("offset") Integer offset);
    Integer getExamScoreStudentCount(@Param("classNo") Integer classNo);
    List<ExamScoreDataDAO> getExamScoreDatas(@Param("examNo") Integer examNo);
    ExamInfoSummaryDAO getExamInfoSummary(@Param("examNo") Integer examNo);
}
