package com.mathedu.mathedu.bbsinfo.mapper;

import com.mathedu.mathedu.bbsinfo.dao.request.BbsInfoDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsDetailInfoDAO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsFileDetailDTO;
import com.mathedu.mathedu.bbsinfo.dao.response.BbsSummaryDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BbsMapper {
    void insertBbs(BbsInfoDAO data);
    void insertBbsFileInfos(@Param("files") List<String> files, @Param("bbsNo") Integer bbsNo);

    void deleteBbs(@Param("bbsNos") Integer[] bbsNos, @Param("teacherNo") Integer teacherNo);

    Integer getTotalBbsCount(@Param("keyword") String keyword);
    List<BbsSummaryDAO> getBbsList(@Param("classNo") Integer classNo, @Param("order") String order, @Param("keyword") String keyword, @Param("offset") Integer offset);

    BbsDetailInfoDAO getBbsDetailInfo(@Param("bbsNo") Integer bbsNo);

    List<BbsFileDetailDTO> getBbsFileList(@Param("bbsNo") Integer bbsNo);
}
