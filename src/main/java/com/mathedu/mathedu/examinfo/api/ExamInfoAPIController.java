package com.mathedu.mathedu.examinfo.api;

import com.mathedu.mathedu.examinfo.dao.request.ExamInfoInsertDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamInfoResponseDAO;
import com.mathedu.mathedu.examinfo.service.ExamInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/exam")
@Api(tags = "시험 정보 관리")
@RequiredArgsConstructor
public class ExamInfoAPIController {
    private final ExamInfoService examInfoService;
    @PutMapping("")
    @ApiOperation(value = "시험 정보 등록", notes = "시험 정보 등록 API")
    public ResponseEntity<ExamInfoResponseDAO> insertExamInfo(
            @RequestBody @ApiParam(value = "시험 정보 등록 객체", required = true) ExamInfoInsertDAO data
    ) {
        ExamInfoResponseDAO response = examInfoService.insertExamInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }
    @PatchMapping("/{examNo}")
    @ApiOperation(value = "시험 정보 수정", notes = "시험 정보 수정 API")
    public ResponseEntity<ExamInfoResponseDAO> updateExamInfo(
            @PathVariable @ApiParam(value = "시험의 DB상의 시퀀스 번호", required = true) Integer examNo,
            @RequestBody @ApiParam(value = "시험 정보 등록 객체 (입력하지 않은 키 값은 업데이트 하지 않음)", required = true) ExamInfoInsertDAO data
    ) {
        ExamInfoResponseDAO response = examInfoService.updateExamInfo(examNo, data);
        return new ResponseEntity<>(response, response.getCode());
    }

}
