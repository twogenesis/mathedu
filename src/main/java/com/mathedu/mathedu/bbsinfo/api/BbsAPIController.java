package com.mathedu.mathedu.bbsinfo.api;

import com.mathedu.mathedu.bbsinfo.dao.request.BbsInsertDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsDetailResponseDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsInsertResponseDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsListResponseDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsResponseDAO;
import com.mathedu.mathedu.bbsinfo.service.BbsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bbs")
@RequiredArgsConstructor
public class BbsAPIController {
    private final BbsService noticeService;
    @PutMapping("")
    public ResponseEntity<BbsInsertResponseDAO> insertBbs(BbsInsertDAO data) throws Exception {
        BbsInsertResponseDAO response = noticeService.insertBbs(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @DeleteMapping("/{noticeNos}/{teacherNo}")
    public ResponseEntity<BbsResponseDAO> deleteBbs(@PathVariable Integer[] noticeNos, @PathVariable Integer teacherNo) {
        BbsResponseDAO response = noticeService.deleteBbs(noticeNos, teacherNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/{classNo}/{order}")
    public ResponseEntity<BbsListResponseDAO> getBbsList(
            @PathVariable Integer classNo, @PathVariable String order, @RequestParam @Nullable String keyword, @RequestParam @Nullable Integer page
    ) {
        BbsListResponseDAO response = noticeService.getBbsList(classNo, order, keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/detail/{noticeNo}")
    public ResponseEntity<BbsDetailResponseDAO> getBbsDetailInfo(@PathVariable Integer noticeNo) {
        BbsDetailResponseDAO response = noticeService.getBbsDetailInfo(noticeNo);
        return new ResponseEntity<>(response, response.getCode());
    }
}
