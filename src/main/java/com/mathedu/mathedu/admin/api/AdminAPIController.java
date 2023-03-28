package com.mathedu.mathedu.admin.api;

import com.mathedu.mathedu.admin.dao.request.AdminClassInsertDAO;
import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherInsertDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherUpdateDAO;
import com.mathedu.mathedu.admin.dao.response.AdminAPIResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminClassListResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminLoginResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminTeacherListResponseDAO;
import com.mathedu.mathedu.admin.service.AdminService;
import io.swagger.annotations.*;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
@Api(tags = "관리자 기능")
public class AdminAPIController {
    private final AdminService adminService;
    @ApiOperation(value = "관리자 로그인", notes = "관리자 아이디와 비밀번호를 통해 관리자 로그인 API")
    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponseDAO> postAdminLogin(
            @RequestBody @ApiParam(value = "관리자 아이디와 비밀번호 입력", required = true) AdminInfoRequestDAO login) throws Exception {
        AdminLoginResponseDAO response = adminService.adminLogin(login);
        return new ResponseEntity<>(response, response.getResponse().getCode());
    }
    @ApiOperation(value = "관리자 등록", notes = "관리자 정보 등록 API")
    @PutMapping("")
    public ResponseEntity<AdminAPIResponseDAO> putAdminInfo(
            @RequestBody @ApiParam(value = "관리자 아이디와 비밀번호 입력", required = true) AdminInfoRequestDAO join) throws Exception{
        AdminAPIResponseDAO response = adminService.addAdminInfo(join);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "관리자 상태 변경", notes = "관리자 상태 변경 API")
    @PatchMapping("/active/{adminNo}/{status}")
    public ResponseEntity<AdminAPIResponseDAO> patchAdminStatus(
            @PathVariable @ApiParam(value = "관리자의 DB상의 시퀀스 번호", required = true) Integer adminNo,
            @PathVariable @ApiParam(value = "관리자의 상태 값 (1:대기/2:사용)", required = true) Integer status) {
        AdminAPIResponseDAO response = adminService.patchAdminStatus(adminNo, status);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "관리자 아이디 중복 확인", notes = "관리자 아이디 중복 확인 API")
    @GetMapping("/checkId/{adminId}")
    public ResponseEntity<AdminAPIResponseDAO> checkAdminId(
            @PathVariable @ApiParam(value = "중복 체크 하고자하는 아이디", required = true) String adminId) {
        AdminAPIResponseDAO response = adminService.checkAdminId(adminId);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "선생님 정보 추가", notes = "선생님 계정 정보 추가 API")
    @PutMapping("/teacher")
    public ResponseEntity<AdminAPIResponseDAO> insertTeacherInfo(
            @ApiParam(value = "선생님 정보 입력 객체", required = true) AdminTeacherInsertDAO data) throws Exception {
        AdminAPIResponseDAO response = adminService.insertTeacherInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "선생님 리스트 조회", notes = "등록된 선생님 리스트 출력 API")
    @GetMapping("/teacher/list/{order}/{orderType}")
    public ResponseEntity<AdminTeacherListResponseDAO> getTeacherList(
            @PathVariable @ApiParam(value = "정렬 방법 (asc, desc)", required = true) String order,
            @PathVariable @ApiParam(value = "정렬 기준 (name, regdt)", required = true) String orderType,
            @RequestParam @ApiParam(value = "검색어 (미입력시 검색하지 않음)", required = false) @Nullable String keyword,
            @RequestParam @ApiParam(value = "페이지 (미입력시 첫번째 페이지 출력)", required = false) @Nullable Integer page)
    {
        AdminTeacherListResponseDAO response = adminService.getTeacherList(order, orderType, keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "선생님 정보 수정", notes = "선생님 계정 정보 수정 API")
    @PatchMapping("/teacher/{teacherId}")
    public ResponseEntity<AdminAPIResponseDAO> updateTeacherInfo(
            @PathVariable @ApiParam(value = "선생님 아이디", required = true) String teacherId,
            @ApiParam(value = "선생님 정보 객체 (null 값으로 세팅된 필드는 업데이트 하지 않음)", required = true) AdminTeacherUpdateDAO data
    ) throws Exception {
        AdminAPIResponseDAO response = adminService.updateTeacherInfo(teacherId, data);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "선생님 정보 삭제", notes = "선생님 계정 정보 삭제 API")
    @DeleteMapping("/teacher/{teacherId}")
    public ResponseEntity<AdminAPIResponseDAO> deleteTeacherInfo(
            @PathVariable @ApiParam(value = "선생님 아이디", required = true) String teacherId) {
        AdminAPIResponseDAO response = adminService.deleteTeacherInfo(teacherId);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "반 정보 추가", notes = "반 정보 추가 API")
    @PutMapping("/class")
    public ResponseEntity<AdminAPIResponseDAO> insertClassInfo(
            @RequestBody @ApiParam(value = "반 정보 추가 객체", required = true) AdminClassInsertDAO data
    ) {
        AdminAPIResponseDAO response = adminService.insertClassInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "반 정보 수정", notes = "반 정보 수정 API")
    @PatchMapping("/class/{classNo}")
    public ResponseEntity<AdminAPIResponseDAO> updateClassInfo(
            @PathVariable @ApiParam(value = "반의 DB상의 시퀀스 번호", required = true) Integer classNo,
            @RequestBody @ApiParam(value = "반 정보 객체 (Null로 세팅된 값은 수정하지 않음)", required = true) AdminClassInsertDAO data
    ) {
        AdminAPIResponseDAO response = adminService.updateClassInfo(classNo, data);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "반 정보 삭제", notes = "반 정보 삭제 API")
    @DeleteMapping("/class/{classNo}")
    public ResponseEntity<AdminAPIResponseDAO> deleteClassInfo(
            @PathVariable @ApiParam(value = "반의 DB상의 시퀀스 번호", required = true) Integer classNo
    ) {
        AdminAPIResponseDAO response = adminService.deleteClassInfo(classNo);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "반 정보 목록 조회", notes = "반 정보 목록 조회 API")
    @GetMapping("/class/list/{orderref}/{order}")
    public ResponseEntity<AdminClassListResponseDAO> getClassList(
            @PathVariable @ApiParam(value = "정렬 기준 (class, teacher, opendt, closedt)", required = true) String orderref,
            @PathVariable @ApiParam(value = "정렬 방향 (asc, desc)", required = true) String order,
            @RequestParam @ApiParam(value = "페이지 번호 (미입력 시 첫번째 페이지)", required = false) @Nullable Integer page,
            @RequestParam @ApiParam(value = "검색어 (미입력 시 검색하지 않음)", required = false) @Nullable String keyword,
            @RequestParam @ApiParam(value = "검색 기준 (class, teacher) 미 입력시 반 이름 기준으로 검색", required = false) @Nullable String searchType
    ) {
        AdminClassListResponseDAO response = adminService.getClassList(orderref, order, page, keyword, searchType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "반 - 선생님 배정", notes = "반 - 선생님 배정 API")
    @PutMapping("/class/teacher/{classNo}/{teacherNo}")
    public ResponseEntity<AdminAPIResponseDAO> addTeacherToClass(
            @PathVariable @ApiParam(value = "반의 DB상의 시퀀스 번호", required = true) Integer classNo, 
            @PathVariable @ApiParam(value = "선생님의 DB상의 시퀀스 번호", required = true) Integer teacherNo
    ) {
        AdminAPIResponseDAO response = adminService.addTeacherToClass(classNo, teacherNo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

