package com.mathedu.mathedu.studentinfo.mapper;

import com.mathedu.mathedu.studentinfo.dao.request.StudentInsertDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper {
    void insertStudentInfo(StudentInsertDAO data);
    Boolean isExistStudentId(@Param("id") String id);
    void updateStudentInfo(@Param("id") String id, @Param("data") StudentInsertDAO data);
    void deleteStudentInfo(@Param("id") String id);

}
