package com.mathedu.mathedu.examinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamScoreDataDAO {
    private Integer examStuSeq;
    private Integer score;
}
