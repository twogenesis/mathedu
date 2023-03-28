package com.mathedu.mathedu.studentinfo.api;

import com.mathedu.mathedu.studentinfo.dao.request.StudentInsertDAO;
import com.mathedu.mathedu.studentinfo.dao.response.StudentResponseDAO;
import com.mathedu.mathedu.studentinfo.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
@RequiredArgsConstructor
@Api(tags = "학생정보 관리")
public class StudentAPIController {
    private final StudentService studentService;
    @ApiOperation(value = "", notes = "")
    @PutMapping("")
    public ResponseEntity<StudentResponseDAO> insertStudentInfo(
            @ApiParam(value = "", required = true) StudentInsertDAO data
    ) throws Exception {
        StudentResponseDAO response = studentService.insertStudentInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }
    @ApiOperation(value = "", notes = "")
    @GetMapping("/check/{id}")
    public ResponseEntity<StudentResponseDAO> checkStudentId(
            @PathVariable @ApiParam(value = "", required = true) String id
    ) {
        StudentResponseDAO response = studentService.checkStudentId(id);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "", notes = "")
    @PatchMapping("/{id}")
    public ResponseEntity<StudentResponseDAO> updateStudentInfo(
            @PathVariable @ApiParam(value = "", required = true) String id,
            @ApiParam(value = "", required = true) StudentInsertDAO data
    ) throws Exception {
        StudentResponseDAO response = studentService.updateStudentInfo(id, data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @ApiOperation(value = "", notes = "")
    @DeleteMapping("/{id}")
    public ResponseEntity<StudentResponseDAO> deleteStudentInfo(
            @PathVariable @ApiParam(value = "", required = true) String id
    ) {
        StudentResponseDAO response = studentService.deleteStudentInfo(id);
        return new ResponseEntity<>(response, response.getCode());
    }
}
