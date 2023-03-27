package com.mathedu.mathedu.admin.dao.response;

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
public class AdminClassListResponseDAO {
    private Integer currentPage;
    private Integer pageCount;
    private Integer totalCount;
    private List<AdminClassSummaryInfoDAO> list;
}
