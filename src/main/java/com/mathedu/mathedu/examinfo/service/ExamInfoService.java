package com.mathedu.mathedu.examinfo.service;

import com.mathedu.mathedu.classinfo.dao.response.ClassExamScoreListResponseDAO;
import com.mathedu.mathedu.classinfo.mapper.ClassInfoMapper;
import com.mathedu.mathedu.examinfo.dao.request.ExamInfoInsertDAO;
import com.mathedu.mathedu.examinfo.dao.response.ExamInfoResponseDAO;
import com.mathedu.mathedu.examinfo.mapper.ExamInfoMapper;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

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


}
