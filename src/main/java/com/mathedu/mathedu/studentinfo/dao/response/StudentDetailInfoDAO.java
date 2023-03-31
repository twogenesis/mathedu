package com.mathedu.mathedu.studentinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentDetailInfoDAO {
    @ApiModelProperty(name = "basicInfo", notes = "학생 기본 등록 정보", required = true)
    private StudentBasicInfoDAO basicInfo;
    @ApiModelProperty(name = "weeklyTest", notes = "최근 주간 테스트 요약", required = true)
    private StudentRecentScoreDAO weeklyTest;
    @ApiModelProperty(name = "monthlyTest", notes = "최근 월간 테스트 요약", required = true)
    private StudentRecentScoreDAO monthlyTest;
}
