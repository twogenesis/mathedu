package com.mathedu.mathedu.teacherinfo.api;

import com.mathedu.mathedu.teacherinfo.dao.response.TeacherDetailInfoResponseDTO;
import com.mathedu.mathedu.teacherinfo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teacher")
@RequiredArgsConstructor
public class TeacherAPIController {
    private final TeacherService teacherService;
    @GetMapping("/{teacherId}")
    public ResponseEntity<TeacherDetailInfoResponseDTO> getTeacherDetailInfo(@PathVariable String teacherId, @RequestParam @Nullable Integer page) {
        TeacherDetailInfoResponseDTO response = teacherService.getTeacherDetailInfo(teacherId, page);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
