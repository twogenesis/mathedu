package com.mathedu.mathedu.admin.api;

import com.mathedu.mathedu.admin.dao.request.AdminClassInsertDAO;
import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherInsertDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherUpdateDAO;
import com.mathedu.mathedu.admin.dao.response.AdminAPIResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminClassListResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminLoginResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminTeacherListResponseDAO;
import com.mathedu.mathedu.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminAPIController {
    private final AdminService adminService;
    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponseDAO> postAdminLogin(@RequestBody AdminInfoRequestDAO login) throws Exception {
        AdminLoginResponseDAO response = adminService.adminLogin(login);
        return new ResponseEntity<>(response, response.getResponse().getCode());
    }
    @PutMapping("")
    public ResponseEntity<AdminAPIResponseDAO> putAdminInfo(@RequestBody AdminInfoRequestDAO join) throws Exception{
        AdminAPIResponseDAO response = adminService.addAdminInfo(join);
        return new ResponseEntity<>(response, response.getCode());
    }

    @PatchMapping("/active/{adminNo}/{status}")
    public ResponseEntity<AdminAPIResponseDAO> patchAdminStatus(@PathVariable Integer adminNo, @PathVariable Integer status) {
        AdminAPIResponseDAO response = adminService.patchAdminStatus(adminNo, status);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/checkId/{adminId}")
    public ResponseEntity<AdminAPIResponseDAO> checkAdminId(@PathVariable String adminId) {
        AdminAPIResponseDAO response = adminService.checkAdminId(adminId);
        return new ResponseEntity<>(response, response.getCode());
    }

    @PutMapping("/teacher")
    public ResponseEntity<AdminAPIResponseDAO> insertTeacherInfo(AdminTeacherInsertDAO data) throws Exception {
        AdminAPIResponseDAO response = adminService.insertTeacherInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/teacher/list/{order}/{orderType}")
    public ResponseEntity<AdminTeacherListResponseDAO> getTeacherList(
            @PathVariable String order,
            @PathVariable String orderType,
            @RequestParam @Nullable String keyword,
            @RequestParam @Nullable Integer page)
    {
        AdminTeacherListResponseDAO response = adminService.getTeacherList(order, orderType, keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }

    @PatchMapping("/teacher/{teacherId}")
    public ResponseEntity<AdminAPIResponseDAO> updateTeacherInfo(@PathVariable String teacherId, AdminTeacherUpdateDAO data) throws Exception {
        AdminAPIResponseDAO response = adminService.updateTeacherInfo(teacherId, data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @DeleteMapping("/teacher/{teacherId}")
    public ResponseEntity<AdminAPIResponseDAO> deleteTeacherInfo(@PathVariable String teacherId) {
        AdminAPIResponseDAO response = adminService.deleteTeacherInfo(teacherId);
        return new ResponseEntity<>(response, response.getCode());
    }

    @PutMapping("/class")
    public ResponseEntity<AdminAPIResponseDAO> insertClassInfo(@RequestBody AdminClassInsertDAO data) {
        AdminAPIResponseDAO response = adminService.insertClassInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @PatchMapping("/class/{classNo}")
    public ResponseEntity<AdminAPIResponseDAO> updateClassInfo(@PathVariable Integer classNo, @RequestBody AdminClassInsertDAO data) {
        AdminAPIResponseDAO response = adminService.updateClassInfo(classNo, data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @DeleteMapping("/class/{classNo}")
    public ResponseEntity<AdminAPIResponseDAO> deleteClassInfo(@PathVariable Integer classNo) {
        AdminAPIResponseDAO response = adminService.deleteClassInfo(classNo);
        return new ResponseEntity<>(response, response.getCode());
    }
//    {orderref}/{asc|desc}?page=1&keyword=검색어&searchtype=class
    @GetMapping("/class/list/{orderref}/{order}")
    public ResponseEntity<AdminClassListResponseDAO> getClassList(
            @PathVariable String orderref,
            @PathVariable String order,
            @RequestParam @Nullable Integer page,
            @RequestParam @Nullable String keyword,
            @RequestParam @Nullable String searchType
    ) {
        AdminClassListResponseDAO response = adminService.getClassList(orderref, order, page, keyword, searchType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}

