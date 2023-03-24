package com.mathedu.mathedu.admin.service;

import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.response.AdminAPIResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminLoginResponseDAO;
import com.mathedu.mathedu.admin.mapper.AdminMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper adminMapper;
    public AdminLoginResponseDAO adminLogin(AdminInfoRequestDAO login) {
        AdminLoginResponseDAO dao = adminMapper.loginUser(login);
        if(dao == null) {
            dao = AdminLoginResponseDAO.builder()
                    .response(
                            AdminAPIResponseDAO.builder()
                                    .status(false)
                                    .message("아이디 또는 비밀번호 오류입니다.")
                                    .code(HttpStatus.UNAUTHORIZED)
                                    .build()
                    )
                    .build();
        }
        else if(dao.getStatus() != 1) {
            dao = AdminLoginResponseDAO.builder()
                    .response(
                            AdminAPIResponseDAO.builder()
                                    .status(false)
                                    .message("승인 대기중인 관리자입니다.")
                                    .code(HttpStatus.UNAUTHORIZED)
                                    .build()
                    )
                    .build();
        }
        else {
            dao.setResponse(
                    AdminAPIResponseDAO.builder()
                            .status(true)
                            .message("로그인 성공")
                            .code(HttpStatus.OK)
                            .build()
            );
        }
        return dao;
    }
}
