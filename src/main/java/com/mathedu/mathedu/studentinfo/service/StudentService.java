package com.mathedu.mathedu.studentinfo.service;

import com.mathedu.mathedu.file.service.FileService;
import com.mathedu.mathedu.studentinfo.dao.request.StudentInsertDAO;
import com.mathedu.mathedu.studentinfo.dao.request.StudentLoginDAO;
import com.mathedu.mathedu.studentinfo.dao.request.StudentPwdUpdateDAO;
import com.mathedu.mathedu.studentinfo.dao.response.*;
import com.mathedu.mathedu.studentinfo.mapper.StudentMapper;
import com.mathedu.mathedu.utils.AESAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final FileService fileService;

    public StudentLoginResponseDAO studentLogin(StudentLoginDAO login) throws Exception {
        login.setPwd(AESAlgorithm.Encrypt(login.getPwd()));
        StudentLoginInfoDAO student = studentMapper.loginStudent(login);
        if(student == null) {
            return StudentLoginResponseDAO.builder()
                    .status(false)
                    .message("아이디 또는 비밀번호 오류입니다.")
                    .code(HttpStatus.UNAUTHORIZED)
                    .build();
        }
        return StudentLoginResponseDAO.builder()
                .status(true)
                .message("로그인 되었습니다.")
                .code(HttpStatus.OK)
                .login(student)
                .build();
    }

    public StudentResponseDAO updatePassword(String id, StudentPwdUpdateDAO data) throws Exception {
        if(!studentMapper.isExistStudentId(id)){
            return StudentResponseDAO.builder()
                    .status(false)
                    .message("아이디가 존재하지 않습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        if(!studentMapper.isValidOldPassword(id, AESAlgorithm.Encrypt(data.getOldPwd()))) {
            return StudentResponseDAO.builder()
                    .status(false)
                    .message("기존 비밀번호가 다릅니다.")
                    .code(HttpStatus.UNAUTHORIZED)
                    .build();
        }
        if(data.getOldPwd().equals(data.getNewPwd())) {
            return StudentResponseDAO.builder()
                    .status(false)
                    .message("기존 비밀번호와 새 비밀번호는 동일하게 설정할 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        data.setNewPwd(AESAlgorithm.Encrypt(data.getNewPwd()));
        data.setOldPwd(AESAlgorithm.Encrypt(data.getOldPwd()));
        studentMapper.updateStudentPassword(id, data);
        return StudentResponseDAO.builder()
                .status(true)
                .message("비밀번호가 변경되었습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    @Transactional
    public StudentResponseDAO insertStudentInfo(StudentInsertDAO data) throws Exception {
        if(studentMapper.isExistStudentId(data.getId())) {
            return StudentResponseDAO.builder()
                    .status(false)
                    .message(data.getId()+"는 이미 등록된 아이디입니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
        if(data.getImage() != null) {
            String filename = fileService.saveImageFile("student", data.getImage());
            data.setImagefile(filename);
        }
        data.setPwd(AESAlgorithm.Encrypt(data.getPwd()));
        studentMapper.insertStudentInfo(data);
        return StudentResponseDAO.builder()
                .status(true)
                .message("학생 정보가 추가되었습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public StudentResponseDAO checkStudentId(String id) {
        if(studentMapper.isExistStudentId(id)) {
            return StudentResponseDAO.builder()
                    .status(false)
                    .message(id+"는 이미 등록된 아이디입니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
        else {
            return StudentResponseDAO.builder()
                    .status(true)
                    .message(id+"는 사용할 수 있습니다.")
                    .code(HttpStatus.OK)
                    .build();
        }
    }

    public StudentResponseDAO updateStudentInfo(@PathVariable String id, StudentInsertDAO data) throws Exception {
        if(!studentMapper.isExistStudentId(id)) {
            return StudentResponseDAO.builder()
                    .status(false)
                    .message("잘못된 학생 아이디 입니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        if(data.getImage() != null) {
            String filename = fileService.saveImageFile("student", data.getImage());
            data.setImagefile(filename);
        }
        if(data.getPwd() != null) {
            data.setPwd(AESAlgorithm.Encrypt(data.getPwd()));
        }
        studentMapper.updateStudentInfo(id, data);
        return StudentResponseDAO.builder()
                .status(true)
                .message("학생 정보를 수정했습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public StudentResponseDAO deleteStudentInfo(String id) {
        if(!studentMapper.isExistStudentId(id)) {
            return StudentResponseDAO.builder()
                    .status(false)
                    .message("잘못된 학생 아이디 입니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        studentMapper.deleteStudentInfo(id);
        return StudentResponseDAO.builder()
                .status(true)
                .message("학생 정보를 삭제했습니다.")
                .code(HttpStatus.OK)
                .build();
    }

    public StudentDetailInfoResponseDAO getStudentDetailInfo(String stuId) {
        if(!studentMapper.isExistStudentId(stuId)) {
            return StudentDetailInfoResponseDAO.builder()
                    .status(false)
                    .message("학생 정보를 찾을 수 없습니다.")
                    .code(HttpStatus.BAD_REQUEST)
                    .build();
        }
        return StudentDetailInfoResponseDAO.builder()
                .status(true)
                .message("학생 정보를 조회했습니다.")
                .code(HttpStatus.OK)
                .info(
                    StudentDetailInfoDAO.builder()
                        .basicInfo(studentMapper.getStudentDetailInfo(stuId))
                        .weeklyTest(studentMapper.getRecentExamScore("weekly", stuId))
                        .monthlyTest(studentMapper.getRecentExamScore("monthly", stuId))
                        .build()
                )
                .build();
    }
    public StudentWeekMonthExamResponseDAO getStudentTestInfo(String stuId, Integer year, Integer month, String order, String type) {
        if(!studentMapper.isExistStudentId(stuId)) {
            return StudentWeekMonthExamResponseDAO.builder().status(false).code(HttpStatus.BAD_REQUEST)
                .message("학생 정보를 찾을 수 없습니다.").build();    
        }
        if(month != null) {
            if (month < 1 || month > 12) {
                return StudentWeekMonthExamResponseDAO.builder().status(false).code(HttpStatus.BAD_REQUEST)
                        .message("month는 1에서 12 사이로 입력해주세요").build();
            }
            if (!(order.equalsIgnoreCase("asc") || order.equalsIgnoreCase("desc"))) {
                return StudentWeekMonthExamResponseDAO.builder().status(false).code(HttpStatus.BAD_REQUEST)
                        .message("정렬 기준은 asc 또는 desc로 입력하세요.").build();
            }
        }
        List<StudentExamTableDataDAO> list = studentMapper.getStudentTestInfo(stuId, year, month, order, type);
        List<Integer> personalScores = new ArrayList<>();
        List<Integer> classAvgScores = new ArrayList<>();
        List<Integer> top30pAvgScores = new ArrayList<>();

        for(StudentExamTableDataDAO data : list) {
            personalScores.add(data.getScore());
            classAvgScores.add(data.getClassAvg());
            top30pAvgScores.add(data.getTop30pAvg());
        }
        return StudentWeekMonthExamResponseDAO.builder()
            .status(true)
            .message("학생의 "+(type.equals("monthly")?"월간":"주간")+" 시험 정보를 조회했습니다.")
            .code(HttpStatus.OK)
            .data(
                StudentWeekMonthExamDAO.builder()
                    .personalScores(personalScores)
                    .classAvgScores(classAvgScores)
                    .top30pAvgScores(top30pAvgScores)
                    .tableData(list)
                    .build()
            )
            .build();
    }
}
























