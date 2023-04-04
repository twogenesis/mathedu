package com.mathedu.mathedu.examinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamInfoSummaryDAO {
    private Integer no;
    private String name;
    private String examDate;
    private String type;
}
