package com.mathedu.mathedu.noticeinfo.mapper;

import com.mathedu.mathedu.noticeinfo.dao.request.NoticeInfoDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeDetailInfoDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeFileDetailDTO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeSummaryDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    void insertNotice(NoticeInfoDAO data);
    void insertNoticeFileInfos(@Param("files") List<String> files, @Param("noticeNo") Integer noticeNo);

    void deleteNotice(@Param("noticeNos") Integer[] noticeNos, @Param("teacherNo") Integer teacherNo);

    Integer getTotalNoticeCount(@Param("keyword") String keyword);
    List<NoticeSummaryDAO> getNoticeList(@Param("classNo") Integer classNo, @Param("order") String order, @Param("keyword") String keyword, @Param("offset") Integer offset);

    NoticeDetailInfoDAO getNoticeDetailInfo(@Param("noticeNo") Integer noticeNo);

    List<NoticeFileDetailDTO> getNoticeFileList(@Param("noticeNo") Integer noticeNo);
}
