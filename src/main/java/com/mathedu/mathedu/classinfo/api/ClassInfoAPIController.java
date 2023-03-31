package com.mathedu.mathedu.classinfo.api;

import com.mathedu.mathedu.classinfo.dao.response.*;
import com.mathedu.mathedu.classinfo.service.ClassInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/class")
@RequiredArgsConstructor
@Api(tags = "반 정보")
public class ClassInfoAPIController {
    private final ClassInfoService classInfoService;
    @ApiOperation(value = "담당 반 리스트 조회", notes = "담당 반 리스트 조회 API")
    @GetMapping("/{teacherId}")
    public ResponseEntity<ClassListResponseDAO> getClassList(
            @PathVariable @ApiParam(value = "선생님 아이디", required = true) String teacherId,
            @RequestParam @ApiParam(value = "페이지 (미 입력시 1번 페이지)") @Nullable Integer page,
            @RequestParam @ApiParam(value = "검색어 (미 입력시 검색하지 않음)") @Nullable String keyword
    ) {
        ClassListResponseDAO response = classInfoService.getClassList(teacherId, page, keyword);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "반 정보 조회", notes = "반 정보 조회 API")
    @GetMapping("/detail/{classNo}")
    public ResponseEntity<ClassInfoResponseDAO> getClassInfo(@PathVariable @ApiParam(value = "반 번호", required = true) Integer classNo) {
        ClassInfoResponseDAO response = classInfoService.getClassInfo(classNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "반 학생 리스트 조회", notes = "반 학생 리스트 조회 API")
    @GetMapping("/student/{classNo}")
    public ResponseEntity<ClassStudentResponseDAO> getClassStudentList(
            @PathVariable @ApiParam(value = "반 번호", required = true) Integer classNo
    ) {
        ClassStudentResponseDAO response = classInfoService.getClassStudentList(classNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 점수 입력 및 수정", notes = "학생 점수 입력 API (점수가 등록되지 않은 상태면 등록, 등록되어있는 상태면 수정으로 작동함)")
    @PutMapping("/exam/{examNo}/{studentId}/{score}")
    public ResponseEntity<ClassStuScoreResponseDAO> insertStudentExamScore(
            @PathVariable @ApiParam(value = "시험의 DB상의 시퀀스 번호", required = true) Integer examNo,
            @PathVariable @ApiParam(value = "학생 아이디", required = true) String studentId,
            @PathVariable @ApiParam(value = "점수", required = true) Integer score
    ) {
        ClassStuScoreResponseDAO response = classInfoService.insertStudentExamScore(examNo, studentId, score);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "학생 점수 리스트 조회", notes = "학생 점수 리스트 조회 API")
    @GetMapping("/exam/{examNo}/list/{sort}/{order}")
    public ResponseEntity<ClassExamScoreListResponseDAO> getExamScoreList(
            @PathVariable @ApiParam(value = "시험의 DB상의 시퀀스 번호", required = true) Integer examNo,
            @PathVariable @ApiParam(value = "정렬기준 (score : 점수, stuno : 학생아이디, stuname : 학생이름)", required = true) String sort,
            @PathVariable @ApiParam(value = "정렬방향 (desc : 내림차순, asc : 오름차순)", required = true) String order
    ) {
        ClassExamScoreListResponseDAO response = classInfoService.getExamScoreList(examNo, sort, order);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "시험 점수 통계데이터 조회", notes = "시험 점수 통계데이터 API")
    @GetMapping("/exam/summary/{examNo}")
    public ResponseEntity<ClassExamScoreSummaryResponseDAO> getExamSummaryData(
            @PathVariable @ApiParam(value = "시험의 DB상의 시퀀스 번호", required = true) Integer examNo
    ) {
        ClassExamScoreSummaryResponseDAO response = classInfoService.getExamSummaryData(examNo);
        return new ResponseEntity<>(response, response.getCode());
    }

}
