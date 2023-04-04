package com.mathedu.mathedu.examinfo.api;

import com.mathedu.mathedu.examinfo.dao.request.ExamInfoInsertDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamInfoListResponseDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamInfoResponseDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamScoreListInfoResponseDAO;
import com.mathedu.mathedu.examinfo.service.ExamInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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
    @GetMapping("/list/{examType}/{classNo}/{orderType}/{order}")
    @ApiOperation(value="시험 리스트 조회", notes = "시험 리스트 조회 API")
    public ResponseEntity<ExamInfoListResponseDAO> getExamList(
            @PathVariable @ApiParam(value = "시험 타입 (월간:monthly, 주간:weekly, 전체:all)") String examType,
            @PathVariable @ApiParam(value = "반의 DB상의 시퀀스 번호") Integer classNo,
            @PathVariable @ApiParam(value = "정렬 기준 (시험이름:examName, 시험일:examDt)") String orderType,
            @PathVariable @ApiParam(value = "정렬 방향 (asc:오름차순, desc:내림차순") String order,
            @RequestParam(required = false) @Nullable @ApiParam(value = "조회할 페이지 (미 입력시 1번 페이지 조회)") Integer page,
            @RequestParam(required = false) @Nullable @ApiParam(value = "검색어 (미 입력 시 검색기능 작동 안함)") String keyword
    ) {
        ExamInfoListResponseDAO response = examInfoService.getExamList(examType, classNo, page, keyword, orderType, order);
        return new ResponseEntity<>(response, response.getCode());
    }
    @GetMapping("/detail/{classNo}/{examNo}")
    @ApiOperation(value="반 시험 점수 리스트 조회", notes = "시험 점수 리스트 조회 API")
    public ResponseEntity<ExamScoreListInfoResponseDAO> getExamDetailList(
            @PathVariable @ApiParam(value = "반의 DB상의 시퀀스 번호") Integer classNo,
            @PathVariable @ApiParam(value = "시험의 DB상의 시퀀스 번호") Integer examNo,
            @RequestParam(required = false) @Nullable @ApiParam(value = "조회할 페이지 (미 입력시 1번 페이지 조회)") Integer page
    ) {
        ExamScoreListInfoResponseDAO response = examInfoService.getExamScoreList(classNo, examNo, page);
        return new ResponseEntity<>(response, response.getCode());
    }

}
