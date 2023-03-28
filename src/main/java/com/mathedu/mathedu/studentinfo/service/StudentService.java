package com.mathedu.mathedu.studentinfo.service;

import com.mathedu.mathedu.file.service.FileService;
import com.mathedu.mathedu.studentinfo.dao.request.StudentInsertDAO;
import com.mathedu.mathedu.studentinfo.dao.response.StudentResponseDAO;
import com.mathedu.mathedu.studentinfo.mapper.StudentMapper;
import com.mathedu.mathedu.utils.AESAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentMapper studentMapper;
    private final FileService fileService;

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
}
