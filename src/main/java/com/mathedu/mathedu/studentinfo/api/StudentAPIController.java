package com.mathedu.mathedu.studentinfo.api;

import com.mathedu.mathedu.studentinfo.dao.request.StudentInsertDAO;
import com.mathedu.mathedu.studentinfo.dao.request.StudentLoginDAO;
import com.mathedu.mathedu.studentinfo.dao.request.StudentPwdUpdateDAO;
import com.mathedu.mathedu.studentinfo.dao.response.StudentDetailInfoResponseDAO;
import com.mathedu.mathedu.studentinfo.dao.response.StudentLoginResponseDAO;
import com.mathedu.mathedu.studentinfo.dao.response.StudentResponseDAO;
import com.mathedu.mathedu.studentinfo.dao.response.StudentWeekMonthExamResponseDAO;
import com.mathedu.mathedu.studentinfo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Api(tags = "학생정보 관리")
public class StudentAPIController {
    private final StudentService studentService;

    @ApiOperation(value = "학생 로그인", notes="학생 로그인 API")
    @PostMapping("/login")
    public ResponseEntity<StudentLoginResponseDAO> postStudentLogin (
            @RequestBody @ApiParam(value = "학생 로그인 정보 객체", required = true) StudentLoginDAO login
    ) throws Exception  {
        StudentLoginResponseDAO response = studentService.studentLogin(login);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "학생 비밀번호 변경", notes="학생 비밀번호 변경 API")
    @PatchMapping("/password/{id}")
    public ResponseEntity<StudentResponseDAO> updatePassword(
            @PathVariable @ApiParam(value = "학생 아이디", required = true) String id,
            @RequestBody @ApiParam(value = "학생 비밀번호 변경 객체", required = true) StudentPwdUpdateDAO data
    ) throws Exception {
        StudentResponseDAO response = studentService.updatePassword(id, data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 정보 입력", notes = "학생 정보 입력 API")
    @PutMapping("")
    public ResponseEntity<StudentResponseDAO> insertStudentInfo(
            @ApiParam(value = "학생 정보 객체", required = true) StudentInsertDAO data
    ) throws Exception {
        StudentResponseDAO response = studentService.insertStudentInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "학생 아이디 중복 체크", notes = "학생 아이디 중복 체크 API")
    @GetMapping("/check/{id}")
    public ResponseEntity<StudentResponseDAO> checkStudentId(
            @PathVariable @ApiParam(value = "학생 아이디", required = true) String id
    ) {
        StudentResponseDAO response = studentService.checkStudentId(id);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 정보 수정", notes = "학생 정보 수정 API (null로 채운 값은 수정하지 않음)")
    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDAO> updateStudentInfo(
            @PathVariable @ApiParam(value = "학생 아이디", required = true) String id,
            @ApiParam(value = "학생 정보 객체", required = true) StudentInsertDAO data
    ) throws Exception {
        StudentResponseDAO response = studentService.updateStudentInfo(id, data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 정보 삭제", notes = "학생 정보 삭제 API")
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDAO> deleteStudentInfo(
            @PathVariable @ApiParam(value = "학생 아이디", required = true) String id
    ) {
        StudentResponseDAO response = studentService.deleteStudentInfo(id);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 상세 정보 조회", notes = "학생 정보 조회 API (기본정보, 최근 주간 테스트, 최근 월간 테스트)")
    @GetMapping("/{stuId}")
    public ResponseEntity<StudentDetailInfoResponseDAO> getStudentDetailInfo(
            @PathVariable @ApiParam(value = "학생 아이디", required = true) String stuId
    ) {
        StudentDetailInfoResponseDAO response = studentService.getStudentDetailInfo(stuId);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 주간 테스트 조회", notes = "학생 주간 테스트 조회 API")
    @GetMapping("/exam/weekly/{stuId}/{year}/{month}/{order}")
    public ResponseEntity<StudentWeekMonthExamResponseDAO> getStudentWeeklyTestInfo(
        @PathVariable @ApiParam(value = "학생 아이디", required = true) String stuId,
        @PathVariable @ApiParam(value = "연도", required = true) Integer year,
        @PathVariable @ApiParam(value = "월", required = true) Integer month,
        @PathVariable @ApiParam(value = "정렬기준 (asc/desc)", required = true) String order
    ) {
        StudentWeekMonthExamResponseDAO response = studentService.getStudentTestInfo(stuId, year, month, order, "weekly");
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 월간 테스트 조회", notes = "학생 주간 테스트 조회 API")
    @GetMapping("/exam/monthly/{stuId}/{year}/{order}")
    public ResponseEntity<StudentWeekMonthExamResponseDAO> getStudentMonthlyTestInfo(
            @PathVariable @ApiParam(value = "학생 아이디", required = true) String stuId,
            @PathVariable @ApiParam(value = "연도", required = true) Integer year,
            @PathVariable @ApiParam(value = "정렬기준 (asc/desc)", required = true) String order
    ) {
        StudentWeekMonthExamResponseDAO response = studentService.getStudentTestInfo(stuId, year, null, order, "monthly");
        return new ResponseEntity<>(response, response.getCode());
    }
}






















