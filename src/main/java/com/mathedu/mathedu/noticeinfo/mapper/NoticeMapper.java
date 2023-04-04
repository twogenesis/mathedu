package com.mathedu.mathedu.noticeinfo.mapper;

import com.mathedu.mathedu.noticeinfo.dao.request.NoticeInfoDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeDetailInfoDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeFileDetailDAO;
import com.mathedu.mathedu.noticeinfo.dao.response.NoticeSummaryDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
    void insertNotice(NoticeInfoDAO data);
    void updateNotice(@Param("notice") NoticeInfoDAO notice, @Param("noticeNo") Integer noticeNo);
    void insertNoticeFileInfos(@Param("files") List<String> files, @Param("noticeNo") Integer noticeNo);
    void deleteNotice(@Param("noticeNos") Integer[] noticeNos, @Param("teacherNo") Integer teacherNo);

    Integer getTotalNoticeCount(@Param("classNo") Integer classNo, @Param("teacherNo") Integer teacherNo, @Param("keyword") String keyword);
    List<NoticeSummaryDAO> getNoticeList(
            @Param("classNo") Integer classNo, @Param("teacherNo") Integer teacherNo,
            @Param("order") String order, @Param("keyword") String keyword, @Param("offset") Integer offset
    );

    NoticeDetailInfoDAO getNoticeDetailInfo(@Param("noticeNo") Integer noticeNo);

    List<NoticeFileDetailDAO> getNoticeFileList(@Param("noticeNo") Integer noticeNo);

    void deleteNoticeFileInfo(@Param("noticeNo") Integer noticeNo, @Param("filename") String filename);
}
