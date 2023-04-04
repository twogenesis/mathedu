package com.mathedu.mathedu.bbsinfo.service;

import com.mathedu.mathedu.file.service.FileService;
import com.mathedu.mathedu.bbsinfo.dao.request.BbsInfoDAO;
import com.mathedu.mathedu.bbsinfo.dao.request.BbsInsertDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.*;
import com.mathedu.mathedu.bbsinfo.mapper.BbsMapper;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsInsertResponseDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsResponseDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BbsService {
    private final BbsMapper bbsMapper;
    private final FileService fileService;
    public BbsInsertResponseDAO insertBbs(BbsInsertDAO data) throws Exception {
        BbsInfoDAO bbs = BbsInfoDAO.builder()
                .title(data.getTitle())
                .content(data.getContent())
                .category(data.getCategory())
                .teacherNo(data.getTeacherNo())
                .classNo(data.getClassNo())
                .build();

        bbsMapper.insertBbs(bbs);

        if(data.getFiles() != null) {
            List<String> files = fileService.saveBoardFiles("bbs", data.getFiles());
            bbsMapper.insertBbsFileInfos(files, bbs.getNo());
        }
        return BbsInsertResponseDAO.builder().bbsNo(bbs.getNo()).status(true).message("자료실 글을 등록했습니다.").code(HttpStatus.OK).build();
    }

    public BbsInsertResponseDAO updateBbs(BbsInsertDAO data, Integer bbsNo) throws Exception {
        if(bbsMapper.getBbsDetailInfo(bbsNo) == null) {
            return BbsInsertResponseDAO.builder().bbsNo(0).status(false).message("자료실 글을 찾을 수 없습니다.").code(HttpStatus.BAD_REQUEST).build();
        }
        BbsInfoDAO bbs = BbsInfoDAO.builder()
                .title(data.getTitle())
                .content(data.getContent())
                .teacherNo(data.getTeacherNo())
                .classNo(data.getClassNo())
                .build();

        if(data.getFiles() != null) {
            List<String> files = fileService.saveBoardFiles("bbs", data.getFiles());
            bbsMapper.insertBbsFileInfos(files, bbsNo);
        }

        bbsMapper.updateBbs(bbs, bbsNo);
        return BbsInsertResponseDAO.builder()
                .bbsNo(bbsNo).status(false).message("자료실 글을 수정했습니다.").code(HttpStatus.OK).build();
    }

    public BbsResponseDAO deleteBbs(Integer[] bbsNos, Integer teacherNo) {
        bbsMapper.deleteBbs(bbsNos, teacherNo);

        return BbsResponseDAO.builder()
                .status(true)
                .message("자료실 글을 삭제했습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public BbsListResponseDAO getBbsList(Integer classNo, Integer teacherNo, String order, String keyword, Integer page) {
        if(keyword == null) keyword = "";
        if(page == null) page = 1;
        Integer totalCnt = bbsMapper.getTotalBbsCount(classNo, teacherNo, keyword);
        Integer totalPage = (int)(Math.ceil(totalCnt / 10.0));
        List<BbsSummaryDAO> list = bbsMapper.getBbsList(classNo, teacherNo, order, keyword, (page-1)*10);
        return BbsListResponseDAO.builder()
                .status(true)
                .totalPage(totalPage)
                .totalCount(totalCnt)
                .currentPage(page)
                .keyword(keyword)
                .list(list)
                .code(HttpStatus.OK)
                .build();
    }

    public BbsDetailResponseDAO getBbsDetailInfo(Integer bbsNo) {
        BbsDetailInfoDAO result = bbsMapper.getBbsDetailInfo(bbsNo);
        BbsDetailResponseDAO response = new BbsDetailResponseDAO();
        if(result == null) {
            response.setCode(HttpStatus.BAD_REQUEST);
        }
        else {
            if(result.getPrevNo() != null) {
                BbsTinyInfo info = BbsTinyInfo.builder()
                        .no(result.getPrevNo())
                        .title(result.getPrevTitle())
                        .build();
                response.setPrevPost(info);
            }
            if(result.getNextNo() != null) {
                BbsTinyInfo info = BbsTinyInfo.builder()
                        .no(result.getNextNo())
                        .title(result.getNextTitle())
                        .build();
                response.setNextPost(info);
            }
            response.setNo(result.getNo());
            response.setClassNo(result.getClassNo());
            response.setCategory(result.getCategory());
            response.setTitle(result.getTitle());
            response.setAuthorName(result.getAuthorName());
            response.setAuthorNo(result.getAuthorNo());
            response.setContents(result.getContents());
            response.setRegDt(result.getRegDt());
            response.setCode(HttpStatus.OK);

            response.setFiles(bbsMapper.getBbsFileList(bbsNo));
        }
        return response;
    }

    public BbsResponseDAO deleteBbsFile(Integer bbsNo, String filename) {
        bbsMapper.deleteBbsFileInfo(bbsNo, filename);
        return BbsResponseDAO.builder()
                .status(true)
                .message("자료실 글 파일을 삭제했습니다.")
                .code(HttpStatus.OK)
                .build();
    }
}
