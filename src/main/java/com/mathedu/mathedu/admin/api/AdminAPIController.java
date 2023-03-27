package com.mathedu.mathedu.admin.api;

import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.request.AdminTeacherInsertDTO;
import com.mathedu.mathedu.admin.dao.response.AdminAPIResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminLoginResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminTeacherListResponseDAO;
import com.mathedu.mathedu.admin.service.AdminService;
import io.swagger.models.Response;
import lombok.RequiredArgsConstructor;
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
    public ResponseEntity<AdminAPIResponseDAO> insertTeacherInfo(AdminTeacherInsertDTO data) throws Exception {
        AdminAPIResponseDAO response = adminService.insertTeacherInfo(data);
        return new ResponseEntity<>(response, response.getCode());
    }

    @GetMapping("/teacher/list")
    public ResponseEntity<AdminTeacherListResponseDAO> getTeacherList(
            @RequestParam @Nullable String keyword,
            @RequestParam @Nullable Integer page)
    {
        AdminTeacherListResponseDAO response = adminService.getTeacherList(keyword, page);
        return new ResponseEntity<>(response, response.getCode());
    }
}
