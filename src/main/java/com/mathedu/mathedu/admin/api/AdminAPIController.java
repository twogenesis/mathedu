package com.mathedu.mathedu.admin.api;

import com.mathedu.mathedu.admin.dao.request.AdminInfoRequestDAO;
import com.mathedu.mathedu.admin.dao.response.AdminAPIResponseDAO;
import com.mathedu.mathedu.admin.dao.response.AdminLoginResponseDAO;
import com.mathedu.mathedu.admin.service.AdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminAPIController {
    private final AdminService adminService;
    @PostMapping("/login")
    public ResponseEntity<AdminLoginResponseDAO> postAdminLogin(@RequestBody AdminInfoRequestDAO login) {
        AdminLoginResponseDAO response = adminService.adminLogin(login);
        return new ResponseEntity<>(response, response.getResponse().getCode());
    }
    @PutMapping("")
    public ResponseEntity<AdminAPIResponseDAO> putAdminInfo(@RequestBody AdminInfoRequestDAO join) {

        return new ResponseEntity<>(response, response.getResponse().getCode());
    }
}
