package com.mathedu.mathedu.admin.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdminTeacherListResponseDAO {
    private Boolean status;
    private String message;
    private List<AdminTeacherInfoDAO> list;
    private Integer totalCount;
    private Integer totalPage;
    private Integer currentPage;
    private String keyword;
    @JsonIgnore
    private HttpStatus code;
}
