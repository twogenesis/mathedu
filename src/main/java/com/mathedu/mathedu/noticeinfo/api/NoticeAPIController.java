package com.mathedu.mathedu.noticeinfo.api;

import com.mathedu.mathedu.noticeinfo.dao.request.NoticeInsertDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeDetailResponseDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeInsertResponseDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeListResponseDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeResponseDAO;
import com.mathedu.mathedu.noticeinfo.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notice")
@RequiredArgsConstructor
public class NoticeAPIController {
    private final NoticeService noticeService;
    @PutMapping("")
    public ResponseEntity<NoticeInsertResponseDAO> insertNotice(NoticeInsertDAO data) throws Exception {
        NoticeInsertResponseDAO response = noticeService.insertNotice(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @PatchMapping("/{noticeNo}")
    public ResponseEntity<NoticeInsertResponseDAO> updateNotice(NoticeInsertDAO data, @PathVariable Integer noticeNo) throws Exception {
        NoticeInsertResponseDAO response = noticeService.updateNotice(data, noticeNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @DeleteMapping("/{noticeNos}/{teacherNo}")
    public ResponseEntity<NoticeResponseDAO> deleteNotice(@PathVariable Integer[] noticeNos, @PathVariable Integer teacherNo) {
        NoticeResponseDAO response = noticeService.deleteNotice(noticeNos, teacherNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/{classNo}/{order}")
    public ResponseEntity<NoticeListResponseDAO> getNoticeList(
            @PathVariable Integer classNo, @PathVariable String order, @RequestParam @Nullable String keyword, @RequestParam @Nullable Integer page
    ) {
        NoticeListResponseDAO response = noticeService.getNoticeList(classNo, order, keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/detail/{noticeNo}")
    public ResponseEntity<NoticeDetailResponseDAO> getNoticeDetailInfo(@PathVariable Integer noticeNo) {
        NoticeDetailResponseDAO response = noticeService.getNoticeDetailInfo(noticeNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @DeleteMapping("/file/{noticeNo}/{filename}")
    public ResponseEntity<NoticeResponseDAO> deleteNoticeFile(@PathVariable Integer noticeNo, @PathVariable String filename) {
        NoticeResponseDAO response = noticeService.deleteNoticeFile(noticeNo, filename);
        return new ResponseEntity<>(response, response.getCode());
    }
}
