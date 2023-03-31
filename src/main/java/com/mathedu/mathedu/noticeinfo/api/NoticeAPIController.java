package com.mathedu.mathedu.noticeinfo.api;

import com.mathedu.mathedu.noticeinfo.dao.request.NoticeInsertDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeDetailResponseDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeInsertResponseDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeListResponseDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeResponseDAO;
import com.mathedu.mathedu.noticeinfo.service.NoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
@Api(tags = "공지사항 관리")
public class NoticeAPIController {
    private final NoticeService noticeService;
    @ApiOperation(value = "글 정보 등록", notes = "글 정보 등록 API")
    @PutMapping("")
    public ResponseEntity<NoticeInsertResponseDAO> insertNotice(
            @ApiParam(value = "글 정보 객체", required = true) NoticeInsertDAO data
    ) throws Exception {
        NoticeInsertResponseDAO response = noticeService.insertNotice(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 정보 수정", notes = "글 정보 수정 API")
    @PatchMapping("/{noticeNo}")
    public ResponseEntity<NoticeInsertResponseDAO> updateNotice(
            @ApiParam(value = "글 정보 수정 객체 (null로 세팅된 값은 수정하지 않음)", required = true) NoticeInsertDAO data,
            @PathVariable @ApiParam(value = "글의 DB상의 시퀀스 번호", required = true) Integer noticeNo) throws Exception {
        NoticeInsertResponseDAO response = noticeService.updateNotice(data, noticeNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 정보 삭제", notes = "글 정보 삭제 API")
    @DeleteMapping("/{noticeNos}/{teacherNo}")
    public ResponseEntity<NoticeResponseDAO> deleteNotice(
            @PathVariable @ApiParam(value = "삭제할 글 번호 리스트 1,2,3 형식으로 씀", required = true) Integer[] noticeNos,
            @PathVariable @ApiParam(value = "글 작성자 번호 (작성자 번호와 맞지 않으면 삭제되지 않음)", required = true) Integer teacherNo) {
        NoticeResponseDAO response = noticeService.deleteNotice(noticeNos, teacherNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 리스트 조회", notes = "글 리스트 조회 API")
    @GetMapping("/{classNo}/{teacherNo}/{order}")
    public ResponseEntity<NoticeListResponseDAO> getNoticeList(
            @PathVariable @ApiParam(value = "반의 DB상의 시퀀스 번호 (0번 입력 시 전체 조회)", required = true) Integer classNo,
            @PathVariable @ApiParam(value = "선생님의 DB상의 시퀀스 번호", required = true) Integer teacherNo,
            @PathVariable @ApiParam(value = "정렬 기준 (asc,desc)", required = true) String order,
            @RequestParam @ApiParam(value = "검색어 (미입력 시 검색하지 않음)", required = false) @Nullable String keyword,
            @RequestParam @ApiParam(value = "페이지 (미입력 시 첫번째 페이지 조회)", required = false) @Nullable Integer page
    ) {
        NoticeListResponseDAO response = noticeService.getNoticeList(classNo, teacherNo, order, keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 상세 정보 조회", notes = "글 상세 정보 조회 API")
    @GetMapping("/detail/{noticeNo}")
    public ResponseEntity<NoticeDetailResponseDAO> getNoticeDetailInfo(
            @PathVariable @ApiParam(value = "글의 DB상의 시퀀스 번호", required = true) Integer noticeNo
    ) {
        NoticeDetailResponseDAO response = noticeService.getNoticeDetailInfo(noticeNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "글 파일 삭제", notes = "글 파일 삭제 API (수정 모드 에서)")
    @DeleteMapping("/file/{noticeNo}/{filename}")
    public ResponseEntity<NoticeResponseDAO> deleteNoticeFile(
            @PathVariable @ApiParam(value = "글의 DB상의 번호", required = true) Integer noticeNo,
            @PathVariable @ApiParam(value = "파일 명 (URL이 아니라 순수 파일이름만 전달)", required = true) String filename) {
        NoticeResponseDAO response = noticeService.deleteNoticeFile(noticeNo, filename);
        return new ResponseEntity<>(response, response.getCode());
    }
}
