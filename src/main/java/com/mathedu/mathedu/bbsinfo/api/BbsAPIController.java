package com.mathedu.mathedu.bbsinfo.api;

import com.mathedu.mathedu.bbsinfo.dao.request.BbsInsertDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsDetailResponseDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsInsertResponseDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsListResponseDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsResponseDAO;
import com.mathedu.mathedu.bbsinfo.service.BbsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bbs")
@RequiredArgsConstructor
@Api(tags = "자료실 관리")
public class BbsAPIController {
    private final BbsService bbsService;
    @ApiOperation(value = "글 정보 등록", notes = "글 정보 등록 API")
    @PutMapping("")
    public ResponseEntity<BbsInsertResponseDAO> insertBbs(
            @ApiParam(value = "글 정보 객체", required = true) BbsInsertDAO data
    ) throws Exception {
        BbsInsertResponseDAO response = bbsService.insertBbs(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 정보 수정", notes = "글 정보 수정 API")
    @PatchMapping("/{bbsNo}")
    public ResponseEntity<BbsInsertResponseDAO> updateBbs(
            @ApiParam(value = "글 정보 수정 객체 (null로 세팅된 값은 수정하지 않음)", required = true) BbsInsertDAO data,
            @PathVariable @ApiParam(value = "글의 DB상의 시퀀스 번호", required = true) Integer bbsNo
    ) throws Exception {
        BbsInsertResponseDAO response = bbsService.updateBbs(data, bbsNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 정보 삭제", notes = "글 정보 삭제 API")
    @DeleteMapping("/{bbsNos}/{teacherNo}")
    public ResponseEntity<BbsResponseDAO> deleteBbs(
            @PathVariable @ApiParam(value = "삭제할 글 번호 리스트 1,2,3 형식으로 씀", required = true) Integer[] bbsNos,
            @PathVariable @ApiParam(value = "글 작성자 번호 (작성자 번호와 맞지 않으면 삭제되지 않음)", required = true)Integer teacherNo
    ) {
        BbsResponseDAO response = bbsService.deleteBbs(bbsNos, teacherNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 리스트 조회", notes = "글 리스트 조회 API")
    @GetMapping("/{classNo}/{teacherNo}/{order}")
    public ResponseEntity<BbsListResponseDAO> getBbsList(
            @PathVariable @ApiParam(value = "반의 DB상의 시퀀스 번호 (0 입력 시 전체 조회)", required = true) Integer classNo,
            @PathVariable @ApiParam(value = "선생님의 DB상의 시퀀스 번호", required = true) Integer teacherNo,
            @PathVariable @ApiParam(value = "정렬 기준 (asc,desc)", required = true) String order,
            @RequestParam @ApiParam(value = "검색어 (미입력 시 검색하지 않음)", required = false) @Nullable String keyword,
            @RequestParam @ApiParam(value = "페이지 (미입력 시 첫번째 페이지 조회)", required = false) @Nullable Integer page
    ) {
        BbsListResponseDAO response = bbsService.getBbsList(classNo, teacherNo, order, keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 상세 정보 조회", notes = "글 상세 정보 조회 API")
    @GetMapping("/detail/{bbsNo}")
    public ResponseEntity<BbsDetailResponseDAO> getBbsDetailInfo(
            @PathVariable @ApiParam(value = "글의 DB상의 시퀀스 번호", required = true) Integer bbsNo
    ) {
        BbsDetailResponseDAO response = bbsService.getBbsDetailInfo(bbsNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 파일 삭제", notes = "글 파일 삭제 API (수정 모드 에서)")
    @DeleteMapping("/file/{bbsNo}/{filename}")
    public ResponseEntity<BbsResponseDAO> deleteBbsFile(
            @PathVariable @ApiParam(value = "글의 DB상의 번호", required = true) Integer bbsNo,
            @PathVariable @ApiParam(value = "파일 명 (URL이 아니라 순수 파일이름만 전달)", required = true) String filename
    ) {
        BbsResponseDAO response = bbsService.deleteBbsFile(bbsNo, filename);
        return new ResponseEntity<>(response, response.getCode());
    }
}
