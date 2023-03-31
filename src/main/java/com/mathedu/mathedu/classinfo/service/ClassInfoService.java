package com.mathedu.mathedu.classinfo.service;

import com.mathedu.mathedu.admin.mapper.AdminMapper;
import com.mathedu.mathedu.classinfo.dao.response.*;
import com.mathedu.mathedu.classinfo.mapper.ClassInfoMapper;
import com.mathedu.mathedu.examinfo.mapper.ExamInfoMapper;
import com.mathedu.mathedu.teacherinfo.dao.response.TeacherInfoDAO;
import com.mathedu.mathedu.teacherinfo.mapper.TeacherMapper;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassInfoService {
    private final ClassInfoMapper classInfoMapper;
    private final TeacherMapper teacherMapper;
    private final AdminMapper adminMapper;
    private final ExamInfoMapper examInfoMapper;
    public ClassListResponseDAO getClassList(String teacherId, Integer page, String keyword) {
        if(!adminMapper.isExistTeacherId(teacherId)) {
            return ClassListResponseDAO.builder()
                    .status(false)
                    .message("존재하지 않는 선생님 아이디 입니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        if(page == null) page = 1;
        if(keyword == null) keyword = "";

        TeacherInfoDAO teacher = teacherMapper.findTeacherInfoById(teacherId);

        Integer totalCnt = classInfoMapper.getClassCountByTeacherNo(teacher.getNo());
        Integer totalPage = (int)(Math.ceil(totalCnt/10.0));

        List<ClassSummaryInfoDAO> list = classInfoMapper.getClassListByTeacherNo(teacher.getNo(), keyword, (page-1)*10);

        return ClassListResponseDAO.builder()
                .status(true)
                .message("반 정보를 조회했습니다.")
                .code(HttpStatus.OK)
                .totalPage(totalPage)
                .totalCount(totalCnt)
                .currentPage(page)
                .list(list)
                .build();
    }
    public ClassInfoResponseDAO getClassInfo(Integer classNo) {
        ClassInfoDAO classinfo = classInfoMapper.getClassInfo(classNo);
        if(classinfo == null) {
            return ClassInfoResponseDAO.builder()
                    .status(false)
                    .message("반 정보를 조회할 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return ClassInfoResponseDAO.builder()
                .status(true)
                .message("반 정보를 조회했습니다.")
                .code(HttpStatus.OK)
                .info(classinfo)
                .build();
    }
    public ClassStudentResponseDAO getClassStudentList(Integer classNo) {
        if(classInfoMapper.getClassInfo(classNo) == null) {
            return ClassStudentResponseDAO.builder()
                    .status(false)
                    .message("학생 리스트를 조회할 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        List<ClassStudentDAO> stuList = classInfoMapper.getClassStudentList(classNo);

        return ClassStudentResponseDAO.builder()
                .status(true)
                .message("학생 리스트를 조회했습니다.")
                .code(HttpStatus.OK)
                .stuList(stuList)
                .build();
    }
    public ClassStuScoreResponseDAO insertStudentExamScore(Integer examNo, String studentId, Integer score) {
        if(!examInfoMapper.isExistExamInfo(examNo)) {
            return ClassStuScoreResponseDAO.builder()
                    .status(true)
                    .message("시험정보가 존재하지 않습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        if(classInfoMapper.isExistExamScore(examNo, studentId)) {
            classInfoMapper.updateStudentExamScore(examNo, studentId, score);
            return ClassStuScoreResponseDAO.builder()
                    .status(true)
                    .message("점수를 수정했습니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
        else {
            classInfoMapper.insertStudentExamScore(examNo, studentId, score);
            return ClassStuScoreResponseDAO.builder()
                    .status(true)
                    .message("점수를 등록했습니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
    }
    public ClassExamScoreListResponseDAO getExamScoreList(Integer examNo, String sort, String order) {
        if(!examInfoMapper.isExistExamInfo(examNo)) {
            return ClassExamScoreListResponseDAO
                    .builder()
                    .status(false)
                    .message("시험 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        List<ClassExamScoreDAO> list = classInfoMapper.getExamScoreList(examNo, sort, order);
        return ClassExamScoreListResponseDAO.builder()
                .status(true)
                .message("시험 점수 정보를 조회했습니다.")
                .code(HttpStatus.OK)
                .list(list)
                .build();
    }
    public ClassExamScoreSummaryResponseDAO getExamSummaryData(Integer examNo) {
        if(!examInfoMapper.isExistExamInfo(examNo)) {
            return ClassExamScoreSummaryResponseDAO
                    .builder()
                    .status(false)
                    .message("시험 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        Integer avg = classInfoMapper.getExamAverageScore(examNo);
        ClassExamStudentTinyInfoDAO max = classInfoMapper.getMaxScoreStudent(examNo);
        ClassExamStudentTinyInfoDAO min = classInfoMapper.getMinScoreStudent(examNo);
        List<Integer> areaData = classInfoMapper.getScoreAreaData(examNo);

        ClassExamScoreSummaryDAO data = ClassExamScoreSummaryDAO.builder()
                .areaData(areaData)
                .maxScore(max)
                .minScore(min)
                .avgScore(avg)
                .build();

        return ClassExamScoreSummaryResponseDAO.builder()
                .status(true)
                .message("시험 점수 통계 정보를 조회했습니다.")
                .code(HttpStatus.OK)
                .summary(data)
                .build();
    }
}
