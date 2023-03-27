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
    private final BbsService bbsService;
    @PutMapping("")
    public ResponseEntity<BbsInsertResponseDAO> insertBbs(BbsInsertDAO data) throws Exception {
        BbsInsertResponseDAO response = bbsService.insertBbs(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @PatchMapping("/{bbsNo}")
    public ResponseEntity<BbsInsertResponseDAO> updateBbs(BbsInsertDAO data, @PathVariable Integer bbsNo) throws Exception {
        BbsInsertResponseDAO response = bbsService.updateBbs(data, bbsNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @DeleteMapping("/{bbsNos}/{teacherNo}")
    public ResponseEntity<BbsResponseDAO> deleteBbs(@PathVariable Integer[] bbsNos, @PathVariable Integer teacherNo) {
        BbsResponseDAO response = bbsService.deleteBbs(bbsNos, teacherNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/{classNo}/{order}")
    public ResponseEntity<BbsListResponseDAO> getBbsList(
            @PathVariable Integer classNo, @PathVariable String order, @RequestParam @Nullable String keyword, @RequestParam @Nullable Integer page
    ) {
        BbsListResponseDAO response = bbsService.getBbsList(classNo, order, keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/detail/{bbsNo}")
    public ResponseEntity<BbsDetailResponseDAO> getBbsDetailInfo(@PathVariable Integer bbsNo) {
        BbsDetailResponseDAO response = bbsService.getBbsDetailInfo(bbsNo);
        return new ResponseEntity<>(response, response.getCode());
    }

    @DeleteMapping("/file/{bbsNo}/{filename}")
    public ResponseEntity<BbsResponseDAO> deleteBbsFile(@PathVariable Integer bbsNo, @PathVariable String filename) {
        BbsResponseDAO response = bbsService.deleteBbsFile(bbsNo, filename);
        return new ResponseEntity<>(response, response.getCode());
    }
}
