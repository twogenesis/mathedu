package com.mathedu.mathedu.admin.mapper;

import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.response.AdminLoginResponseDAO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {
    AdminLoginResponseDAO loginUser(AdminInfoRequestDAO login);
    Boolean isExistId(String id);
    void addAdminInfo(AdminInfoRequestDAO join);
}
