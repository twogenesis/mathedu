package com.mathedu.mathedu.noticeinfo.service;

import com.mathedu.mathedu.file.service.FileService;
import com.mathedu.mathedu.noticeinfo.dao.request.NoticeInfoDAO;
import com.mathedu.mathedu.noticeinfo.dao.request.NoticeInsertDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.*;
import com.mathedu.mathedu.noticeinfo.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {
    private final NoticeMapper noticeMapper;
    private final FileService fileService;
    public NoticeInsertResponseDAO insertNotice(NoticeInsertDAO data) throws Exception {
        NoticeInfoDAO notice = NoticeInfoDAO.builder()
                .title(data.getTitle())
                .content(data.getContent())
                .category(data.getCategory())
                .teacherNo(data.getTeacherNo())
                .classNo(data.getClassNo())
                .build();

        noticeMapper.insertNotice(notice);

        if(data.getFiles() != null) {
            List<String> files = fileService.saveBoardFiles("notice", data.getFiles());
            noticeMapper.insertNoticeFileInfos(files, notice.getNo());
        }
        return NoticeInsertResponseDAO.builder().noticeNo(notice.getNo()).status(true).message("공지사항을 등록했습니다.").code(HttpStatus.OK).build();
    }

    public NoticeInsertResponseDAO updateNotice(NoticeInsertDAO data, Integer noticeNo) throws Exception {
        if(noticeMapper.getNoticeDetailInfo(noticeNo) == null) {
            return NoticeInsertResponseDAO.builder().noticeNo(0).status(false).message("공지사항을 찾을 수 없습니다.").code(HttpStatus.BAD_REQUEST).build();
        }
        NoticeInfoDAO notice = NoticeInfoDAO.builder()
                .title(data.getTitle())
                .content(data.getContent())
                .teacherNo(data.getTeacherNo())
                .classNo(data.getClassNo())
                .build();

        if(data.getFiles() != null) {
            List<String> files = fileService.saveBoardFiles("notice", data.getFiles());
            noticeMapper.insertNoticeFileInfos(files, noticeNo);
        }

        noticeMapper.updateNotice(notice, noticeNo);
        return NoticeInsertResponseDAO.builder()
                .noticeNo(noticeNo).status(false).message("공지사항을 수정했습니다.").code(HttpStatus.OK).build();
    }

    public NoticeResponseDAO deleteNotice(Integer[] noticeNos, Integer teacherNo) {
        noticeMapper.deleteNotice(noticeNos, teacherNo);

        return NoticeResponseDAO.builder()
                .status(true)
                .message("공지사항을 삭제했습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public NoticeListResponseDAO getNoticeList(Integer classNo, Integer teacherNo, String order, String keyword, Integer page) {
        if(keyword == null) keyword = "";
        if(page == null) page = 1;
        Integer totalCnt = noticeMapper.getTotalNoticeCount(classNo, teacherNo, keyword);
        Integer totalPage = (int)(Math.ceil(totalCnt / 10.0));
        List<NoticeSummaryDAO> list = noticeMapper.getNoticeList(classNo, teacherNo, order, keyword, (page-1)*10);
        return NoticeListResponseDAO.builder()
                .status(true)
                .totalPage(totalPage)
                .totalCount(totalCnt)
                .currentPage(page)
                .keyword(keyword)
                .list(list)
                .code(HttpStatus.OK)
                .build();
    }

    public NoticeDetailResponseDAO getNoticeDetailInfo(Integer noticeNo) {
        NoticeDetailInfoDAO result = noticeMapper.getNoticeDetailInfo(noticeNo);
        NoticeDetailResponseDAO response = new NoticeDetailResponseDAO();
        if(result == null) {
            response.setCode(HttpStatus.BAD_REQUEST);
        }
        else {
            if(result.getPrevNo() != null) {
                NoticeTinyInfo info = NoticeTinyInfo.builder()
                        .no(result.getPrevNo())
                        .title(result.getPrevTitle())
                        .build();
                response.setPrevPost(info);
            }
            if(result.getNextNo() != null) {
                NoticeTinyInfo info = NoticeTinyInfo.builder()
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

            response.setFiles(noticeMapper.getNoticeFileList(noticeNo));
        }
        return response;
    }

    public NoticeResponseDAO deleteNoticeFile(Integer noticeNo, String filename) {
        noticeMapper.deleteNoticeFileInfo(noticeNo, filename);
        return NoticeResponseDAO.builder()
                .status(true)
                .message("공지사항 파일을 삭제했습니다.")
                .code(HttpStatus.OK)
                .build();
    }
}
