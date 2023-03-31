package com.mathedu.mathedu.teacherinfo.api;

import com.mathedu.mathedu.teacherinfo.dao.request.TeacherLoginDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherClassListResponseDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherDetailInfoResponseDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherLoginResponseDAO;
import com.mathedu.mathedu.teacherinfo.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
@Api(tags = "선생님 정보")
public class TeacherAPIController {
    private final TeacherService teacherService;
    @ApiOperation(value = "선생님 상세 정보 조회", notes = "선생님 상세 정보 조회 API")
    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDetailInfoResponseDAO> getTeacherDetailInfo(
            @PathVariable @ApiParam(value = "선생님 아이디", required = true) String teacherId,
            @RequestParam @ApiParam(value = "페이지 번호 (미입력 시 1번 페이지 조회)", required = false) @Nullable Integer page) {
        TeacherDetailInfoResponseDAO response = teacherService.getTeacherDetailInfo(teacherId, page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "선생님 로그인", notes = "선생님 로그인 API")
    @PostMapping("/login")
    public ResponseEntity<TeacherLoginResponseDAO> loginTeacher(
            @RequestBody @ApiParam(value = "선생님 로그인 정보 객체", required = true) TeacherLoginDAO login
    ) throws Exception {
        TeacherLoginResponseDAO response = teacherService.loginTeacher(login);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @ApiOperation(value = "선생님 담당 반 리스트 조회", notes = "선생님 담당 반 리스트 조회 API")
    @GetMapping("/classList/{teacherId}")
    public ResponseEntity<TeacherClassListResponseDAO> getTeacherClassList(
            @PathVariable @ApiParam(value = "선생님 아이디", required = true) String teacherId
    ) {
        TeacherClassListResponseDAO response = teacherService.getTeacherClassList(teacherId);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
