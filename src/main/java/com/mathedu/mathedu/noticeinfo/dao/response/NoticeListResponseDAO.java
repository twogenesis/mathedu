package com.mathedu.mathedu.noticeinfo.dao.response;

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
public class NoticeListResponseDAO {
    private Boolean status;
    private Integer totalPage;
    private Integer currentPage;
    private Integer totalCount;
    private String keyword;
    private List<NoticeSummaryDAO> list;
    @JsonIgnore
    private HttpStatus code;
}
