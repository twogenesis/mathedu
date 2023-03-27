package com.mathedu.mathedu.admin.mapper;

import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.response.AdminInfoDAO;
import com.mathedu.mathedu.admin.dao.response.AdminLoginResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminTeacherInfoDAO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {
    AdminLoginResponseDAO loginUser(AdminInfoRequestDAO login);
    Boolean isExistId(String id);
    void addAdminInfo(AdminInfoRequestDAO join);
    AdminInfoDAO getAdminInfoByAdminNo(Integer adminNo);
    void updateAdminStatus(Integer adminNo, Integer status);

    void insertTeacherInfo(String id, String pwd, String name, String imageFile);
    List<AdminTeacherInfoDAO> getTeacherList(String keyword, Integer offset);
    Integer getTeacherTotalCnt(String keyword);
    Boolean isExistTeacherId(String teacherId);

}
