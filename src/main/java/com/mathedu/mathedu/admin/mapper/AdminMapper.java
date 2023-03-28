package com.mathedu.mathedu.admin.mapper;

import com.mathedu.mathedu.admin.dao.request.AdminClassInsertDAO;
import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.response.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminMapper {
    AdminLoginResponseDAO loginUser(AdminInfoRequestDAO login);
    Boolean isExistId(@Param("id") String id);
    void addAdminInfo(AdminInfoRequestDAO join);
    AdminInfoDAO getAdminInfoByAdminNo(@Param("adminNo") Integer adminNo);
    void updateAdminStatus(@Param("adminNo") Integer adminNo, @Param("v") Integer status);

    void insertTeacherInfo(
            @Param("id") String id,@Param("pwd") String pwd, @Param("name") String name, @Param("imageFile") String imageFile);
    List<AdminTeacherInfoDAO> getTeacherList(
            @Param("order") String order, @Param("orderType") String orderType, @Param("keyword") String keyword,
            @Param("offset") Integer offset);
    Integer getTeacherTotalCnt(@Param("keyword") String keyword);
    Boolean isExistTeacherId(@Param("teacherId") String teacherId);
    void updateTeacherInfo(@Param("teacherId") String teacherId, @Param("pwd") String pwd, @Param("name") String name,
                           @Param("filename") String filename);

    void deleteTeacherInfoById(@Param("teacherId") String teacherId);
    void insertClassInfo(AdminClassInsertDAO data);
    void updateClassInfo(@Param("classNo") Integer classNo, @Param("data") AdminClassInsertDAO data);
    AdminClassInfoDAO getClassInfoBySeq(@Param("no") Integer no);
    void deleteClassByClassNo(@Param("classNo") Integer classNo);

    Integer getTotalClassCnt(
            @Param("keyword") String keyword,
            @Param("searchType") String searchType
    );
    List<AdminClassSummaryInfoDAO> getClassList(
            @Param("orderref") String orderref,
            @Param("order") String order,
            @Param("offset") Integer offset,
            @Param("keyword") String keyword,
            @Param("searchType") String searchType
    );
    void addTeacherToClass(@Param("classNo") Integer classNo,@Param("teacherNo") Integer teacherNo);
    Boolean isAlreadyAssignTeacher(@Param("classNo") Integer classNo,@Param("teacherNo") Integer teacherNo);
    void updateClassTeacher(@Param("classConnNo") Integer classConnNo, @Param("teacherNo") Integer teacherNo);
    Boolean getConnInfoBySeq(@Param("classConnNo") Integer classConnNo);
}
