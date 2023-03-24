package com.mathedu.mathedu.admin.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminInfoRequestDAO {
    private String id;
    private String pwd;
}
