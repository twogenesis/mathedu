package com.mathedu.mathedu.examinfo.service;

import com.mathedu.mathedu.classinfo.mapper.ClassInfoMapper;
import com.mathedu.mathedu.examinfo.dao.request.ExamInfoInsertDAO;
import com.mathedu.mathedu.examinfo.dao.response.*;
import com.mathedu.mathedu.examinfo.mapper.ExamInfoMapper;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.annotations.Param;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ExamInfoService {
    private final ExamInfoMapper examInfoMapper;
    private final ClassInfoMapper classInfoMapper;
    public ExamInfoResponseDAO insertExamInfo(ExamInfoInsertDAO data) {
        if(classInfoMapper.getClassInfo(data.getClassNo()) == null) {
            return ExamInfoResponseDAO.builder()
                    .status(false)
                    .message("반 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        examInfoMapper.insertExamInfo(data);

        return ExamInfoResponseDAO.builder()
                .status(true)
                .message("시험 정보를 등록했습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public ExamInfoResponseDAO updateExamInfo(Integer examNo, ExamInfoInsertDAO data){
        if(!examInfoMapper.isExistExamInfo(examNo)) {
            return ExamInfoResponseDAO.builder()
                    .status(false)
                    .message("시험 정보가 존재하지 않습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }

        examInfoMapper.updateExamInfo(examNo, data);

        return ExamInfoResponseDAO.builder()
                .status(true)
                .message("시험 정보를 수정했습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public ExamInfoListResponseDAO getExamList(
            String examType,
            Integer classNo, Integer page, String keyword, String orderType, String order) {
        if(page == null) page = 1;
        if(keyword == null) keyword = "";
        List<ExamInfoDAO> list = examInfoMapper.getExamList(
                examType,
                classNo, (page-1)*10, keyword, orderType, order);
        Integer totalCnt = examInfoMapper.getExamListCount(examType, classNo, keyword);
        Integer totalPage = (int)(Math.ceil(totalCnt/10.0));

        return ExamInfoListResponseDAO.builder()
                .status(true).message("시험 리스트를 조회했습니다.").totalCount(totalCnt).totalPage(totalPage)
                .currentPage(page).list(list).code(HttpStatus.OK)
                .build();
    }
    public ExamScoreListInfoResponseDAO getExamScoreList(Integer classNo, Integer examNo, Integer page) {
        if(page == null) page = 1;

        List<ExamScoreInfoDAO> examScoreInfoList = examInfoMapper.getExamScoreStudentList(classNo, (page-1) * 10);
        List<ExamScoreDataDAO> examScoreDataList = examInfoMapper.getExamScoreDatas(examNo);
        ExamInfoSummaryDAO examSummaryInfo = examInfoMapper.getExamInfoSummary(examNo);

        for(ExamScoreInfoDAO scoreInfo : examScoreInfoList) {
            scoreInfo.setExamName(examSummaryInfo.getName());
            scoreInfo.setExamNo(examSummaryInfo.getNo());
            scoreInfo.setExamDt(examSummaryInfo.getExamDate());
            for(ExamScoreDataDAO data : examScoreDataList) {
                if(scoreInfo.getStudentNo() == data.getExamStuSeq()) {
                    scoreInfo.setScore(data.getScore());
                }
            }
        }
        Integer totalCnt = examInfoMapper.getExamScoreStudentCount(classNo);
        Integer totalPage = (int)(Math.ceil(totalCnt/10.0));

        return ExamScoreListInfoResponseDAO.builder()
                .status(true).message("시험 점수 정보를 조회했습니다.").totalPage(totalPage)
                .currentPage(page).totalCount(totalCnt).list(examScoreInfoList)
                .code(HttpStatus.OK).build();

//        List<ExamScoreInfoDAO> list = examInfoMapper.getExamScoreList(classNo, (page-1) * 10);
//        Integer totalCnt = examInfoMapper.getExamScoreListCount(classNo);
//        Integer totalPage = (int)(Math.ceil(totalCnt/10.0));
//
//        return ExamScoreListInfoResponseDAO.builder()
//                .status(true).message("시험 점수 정보를 조회했습니다.").totalPage(totalPage)
//                .currentPage(page).totalCount(totalCnt).list(list)
//                .code(HttpStatus.OK).build();
    }
}
