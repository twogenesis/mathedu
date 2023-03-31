package com.mathedu.mathedu.examinfo.mapper;

import com.mathedu.mathedu.examinfo.dao.request.ExamInfoInsertDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ExamInfoMapper {
    void insertExamInfo(ExamInfoInsertDAO data);
    Boolean isExistExamInfo(@Param("examNo") Integer examNo);

    void updateExamInfo(@Param("examNo") Integer examNo, @Param("data") ExamInfoInsertDAO data);
}
