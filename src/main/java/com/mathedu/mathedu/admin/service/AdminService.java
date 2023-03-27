package com.mathedu.mathedu.admin.service;

import com.mathedu.mathedu.admin.dao.request.AdminClassInsertDAO;
import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherInsertDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherUpdateDAO;
import com.mathedu.mathedu.admin.dao.response.*;
import com.mathedu.mathedu.admin.mapper.AdminMapper;
import com.mathedu.mathedu.file.service.FileService;
import com.mathedu.mathedu.utils.AESAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

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

    public AdminAPIResponseDAO insertTeacherInfo(AdminTeacherInsertDAO data) throws Exception {
        AdminAPIResponseDAO response;
        if(adminMapper.isExistTeacherId(data.getId())) {
            response = AdminAPIResponseDAO.builder()
                    .status(false)
                    .message(data.getId() + "은/는 이미 등록된 아이디입니다.")
                    .code(HttpStatus.BAD_REQUEST).build();
        }
        else {
            String imageFileName = fileService.saveImageFile("teacher", data.getImageFile());
            adminMapper.insertTeacherInfo(data.getId(), AESAlgorithm.Encrypt(data.getPwd()), data.getName(), imageFileName);
            response = AdminAPIResponseDAO.builder()
                    .status(true)
                    .message("선생님 정보를 등록했습니다.")
                    .code(HttpStatus.OK).build();
        }
        return response;
    }

    public AdminTeacherListResponseDAO getTeacherList(String order, String orderType, String keyword, Integer page) {
        if(keyword == null) keyword = "";
        if(page == null) page = 1;
        Integer offset = (page-1)*10;
        List<AdminTeacherInfoDAO> list = adminMapper.getTeacherList(order, orderType, keyword, offset);
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

    public AdminAPIResponseDAO updateTeacherInfo(String teacherId, AdminTeacherUpdateDAO data) throws Exception {

        if(adminMapper.isExistTeacherId(teacherId)) {
            if(data.getPwd() == null) {
                return AdminAPIResponseDAO.builder()
                        .status(false)
                        .message("비밀번호는 필수 입력사항입니다.")
                        .code(HttpStatus.BAD_REQUEST)
                        .build();
            }
            String filename = null;
            if(data.getImageFile() != null) {
                filename = fileService.saveImageFile("teacher", data.getImageFile());
            }
            adminMapper.updateTeacherInfo(teacherId, AESAlgorithm.Encrypt(data.getPwd()), data.getName(), filename);

            return AdminAPIResponseDAO.builder()
                    .status(true)
                    .message("선생님 정보를 수정했습니다.")
                    .code(HttpStatus.OK)
                    .build();

        }
        else {
            return AdminAPIResponseDAO.builder()
                    .status(false)
                    .message("선생님 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
    }

    public AdminAPIResponseDAO deleteTeacherInfo(String teacherId) {
        if(adminMapper.isExistTeacherId(teacherId)) {
            adminMapper.deleteTeacherInfoById(teacherId);
            return AdminAPIResponseDAO.builder()
                    .status(true)
                    .message("선생님 정보를 삭제했습니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
        else {
            return AdminAPIResponseDAO.builder()
                    .status(false)
                    .message("선생님 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
    }
// "name":"반 이름",
//         "grade":2,
//         "days":"월,수,금",
//         "opendt":"2023-03-01",
//         "closedt":"2023-03-31",
//         "starttime":"18:30",
//         "endtime":"20:30",
//         "teacherNo":1
    public AdminAPIResponseDAO insertClassInfo(AdminClassInsertDAO data) {
        Boolean valid = true;
        String notExistsValues = "";
        if(data.getName() == null) {
            valid = false;
            notExistsValues += " 반이름 ";
        }if(data.getGrade() == null) {
            valid = false;
            notExistsValues += " 학년 ";
        }if(data.getDays() == null) {
            valid = false;
            notExistsValues += " 수업요일 ";
        }if(data.getOpendt() == null) {
            valid = false;
            notExistsValues += " 개강일 ";
        }if(data.getClosedt() == null) {
            valid = false;
            notExistsValues += " 종강일 ";
        }if(data.getStarttime() == null) {
            valid = false;
            notExistsValues += " 시작시간 ";
        }if(data.getEndtime() == null) {
            valid = false;
            notExistsValues += " 종료시간 ";
        }if(data.getTeacherNo() == null) {
            valid = false;
            notExistsValues += " 담당선생님 ";
        }

        if(!valid) {
            return AdminAPIResponseDAO.
                    builder()
                    .status(false)
                    .message("반 정보에 누락 값이 있습니다 ("+notExistsValues+")")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        adminMapper.insertClassInfo(data);
        return AdminAPIResponseDAO.
                builder()
                .status(true)
                .message("반 정보를 추가하였습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public AdminAPIResponseDAO updateClassInfo(Integer classNo, AdminClassInsertDAO data) {

        if(adminMapper.getClassInfoBySeq(classNo) == null) {
            return AdminAPIResponseDAO.
                    builder()
                    .status(false)
                    .message("반 정보가 잘못되었습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }

        adminMapper.updateClassInfo(classNo, data);
        return AdminAPIResponseDAO.
                builder()
                .status(true)
                .message("반 정보를 수정하였습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public AdminAPIResponseDAO deleteClassInfo(Integer classNo) {
        if(adminMapper.getClassInfoBySeq(classNo) == null) {
            return AdminAPIResponseDAO.
                    builder()
                    .status(false)
                    .message("반 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        else {
            adminMapper.deleteClassByClassNo(classNo);
            return AdminAPIResponseDAO.
                    builder()
                    .status(true)
                    .message("반 정보를 삭제하였습니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
    }

    public AdminClassListResponseDAO getClassList(String orderref,String order,Integer page, String keyword, String searchType) {
        if(page == null) page = 1;
        if(keyword == null) keyword = "";
        if(searchType == null) searchType = "class";

        Integer totalCnt = adminMapper.getTotalClassCnt(keyword, searchType);
        Integer totalPage = (int)(Math.ceil(totalCnt/10.0));

        return AdminClassListResponseDAO.builder()
                .pageCount(totalPage)
                .totalCount(totalCnt)
                .currentPage(page)
                .list(adminMapper.getClassList(orderref, order, (page-1)*10, keyword, searchType))
                .build();
    }
}
