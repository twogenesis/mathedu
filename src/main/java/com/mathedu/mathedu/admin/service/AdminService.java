package com.mathedu.mathedu.admin.service;

import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherInsertDTO;
import com.mathedu.mathedu.admin.dao.response.*;
import com.mathedu.mathedu.admin.mapper.AdminMapper;
import com.mathedu.mathedu.file.service.FileService;
import com.mathedu.mathedu.utils.AESAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {
    private final AdminMapper adminMapper;
    private final FileService fileService;
    public AdminLoginResponseDAO adminLogin(AdminInfoRequestDAO login) throws Exception {
        login.setPwd(AESAlgorithm.Encrypt(login.getPwd()));
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

    public AdminAPIResponseDAO addAdminInfo(AdminInfoRequestDAO join) throws Exception {
        AdminAPIResponseDAO response;
        if(adminMapper.isExistId(join.getId())) {
            response = AdminAPIResponseDAO.builder().status(false).message(join.getId()+"은/는 이미 등록된 아이디입니다.")
                    .code(HttpStatus.CONFLICT).build();
        }
        else {
            join.setPwd(AESAlgorithm.Encrypt(join.getPwd()));
            adminMapper.addAdminInfo(join);
            response = AdminAPIResponseDAO.builder().status(true).message("관리자 계정이 사용대기로 등록되었습니다.")
                    .code(HttpStatus.OK).build();
        }
        return response;
    }
    public AdminAPIResponseDAO patchAdminStatus(Integer adminNo, Integer status) {
        AdminAPIResponseDAO response;
        AdminInfoDAO admin = adminMapper.getAdminInfoByAdminNo(adminNo);
        if(admin == null) {
            response = AdminAPIResponseDAO.builder()
                    .status(false)
                    .message("관리자 계정 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST).build();
        }
        else {
            adminMapper.updateAdminStatus(adminNo, status);
            response = AdminAPIResponseDAO.builder()
                    .status(true)
                    .message("관리자 상태를 "+(status == 1?"사용대기":"사용가능")+"(으)로 변경했습니다.")
                    .code(HttpStatus.OK).build();
        }
        return response;
    }
    public AdminAPIResponseDAO checkAdminId(String adminId) {
        AdminAPIResponseDAO response;
        if(adminMapper.isExistId(adminId)) {
            response = AdminAPIResponseDAO.builder()
                    .status(true)
                    .message(adminId+"은/는 이미 등록된 아이디입니다.")
                    .code(HttpStatus.OK).build();
        }
        else {
            response = AdminAPIResponseDAO.builder()
                    .status(false)
                    .message(adminId+"은/는 사용할 수 있습니다.")
                    .code(HttpStatus.OK).build();
        }
        return response;
    }

    public AdminAPIResponseDAO insertTeacherInfo(AdminTeacherInsertDTO data) throws Exception {
        AdminAPIResponseDAO response;
        if(adminMapper.isExistTeacherId(data.getId())) {
            response = AdminAPIResponseDAO.builder()
                    .status(false)
                    .message(data.getId() + "은/는 이미 등록된 아이디입니다.")
                    .code(HttpStatus.BAD_REQUEST).build();
        }
        else {
            String imageFileName = fileService.saveImageFile("teacher", data.getImageFile());
            adminMapper.insertTeacherInfo(data.getId(),data.getPwd(), data.getName(), imageFileName);
            response = AdminAPIResponseDAO.builder()
                    .status(true)
                    .message("선생님 정보를 등록했습니다.")
                    .code(HttpStatus.OK).build();
        }
        return response;
    }

    public AdminTeacherListResponseDAO getTeacherList(String keyword, Integer page) {
        if(keyword == null) keyword = "";
        if(page == null) page = 1;
        Integer offset = (page-1)*10;
        List<AdminTeacherInfoDAO> list = adminMapper.getTeacherList(keyword, offset);
        Integer totalCnt = adminMapper.getTeacherTotalCnt(keyword);
        return
            AdminTeacherListResponseDAO.builder()
                    .status(true)
                    .message("선생님 리스트를 조회했습니다.")
                    .keyword(keyword)
                    .currentPage(page)
                    .list(list)
                    .totalCount(totalCnt)
                    .totalPage((int)(Math.ceil(totalCnt/10.0)))
                    .code(HttpStatus.OK)
                    .build();
    }
}
