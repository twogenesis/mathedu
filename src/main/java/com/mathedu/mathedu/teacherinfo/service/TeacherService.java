package com.mathedu.mathedu.teacherinfo.service;

import com.mathedu.mathedu.teacherinfo.dao.request.TeacherLoginDAO;
import com.mathedu.mathedu.teacherinfo.dao.response.*;
import com.mathedu.mathedu.teacherinfo.mapper.TeacherMapper;
import com.mathedu.mathedu.utils.AESAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherMapper teacherMapper;
    public TeacherDetailInfoResponseDAO getTeacherDetailInfo(String teacherId, Integer page) {
        if(page == null) page = 1;
        TeacherInfoDAO teacher = teacherMapper.findTeacherInfoById(teacherId);
        if(teacher == null) {
            return null;
        }
        Integer totalCount = teacherMapper.getStudentCountByTeacherNo(teacher.getNo());
        Integer totalPage = (int)(Math.ceil(totalCount/10.0));

        List<TeacherStudentInfoDAO> stuList = teacherMapper.getStudentListByTeacherNo(teacher.getNo(), (page-1)*10);
        return TeacherDetailInfoResponseDAO.builder()
                .id(teacher.getId())
                .name(teacher.getName())
                .status(teacher.getStatus())
                .imageURL(teacher.getImageURL())
                .regdt(teacher.getRegdt())
                .stuList(stuList)
                .totalStuCount(totalCount)
                .totalStuPage(totalPage)
                .currentStuPage(page)
                .build();
    }

    public TeacherLoginResponseDAO loginTeacher(TeacherLoginDAO login) throws Exception {
        login.setPwd(AESAlgorithm.Encrypt(login.getPwd()));
        TeacherSummaryDAO teacher = teacherMapper.loginTeacher(login);
        if(teacher == null) {
            return TeacherLoginResponseDAO.builder()
                    .status(false)
                    .message("아이디 또는 비밀번호 오류입니다.")
                    .code(HttpStatus.UNAUTHORIZED)
                    .build();
        }

        return TeacherLoginResponseDAO.builder()
                .status(true)
                .message("로그인 되었습니다.")
                .code(HttpStatus.OK)
                .teacher(teacher)
                .build();
    }

    public TeacherClassListResponseDAO getTeacherClassList(@PathVariable String teacherId) {
        if(teacherMapper.findTeacherInfoById(teacherId) == null) {
            return TeacherClassListResponseDAO.builder()
                .status(false)
                .message("선생님 정보를 찾을 수 없습니다.")
                .code(HttpStatus.UNAUTHORIZED)
                .build();
        }

        return TeacherClassListResponseDAO.builder()
            .status(true)
            .message("반 목록을 조회했습니다.")
            .code(HttpStatus.OK)
            .classList(teacherMapper.getTeacherClassList(teacherId))
            .build();
    }
}
