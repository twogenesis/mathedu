package com.mathedu.mathedu.examinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExamScoreInfoDAO {
    @ApiModelProperty(name = "studentNo", example = "1", notes = "학생의 DB상의 시퀀스 번호", required = true)
    private Integer studentNo;
    @ApiModelProperty(name = "studentName", example = "김학생", notes = "학생 이름", required = true)
    private String studentName;
    @ApiModelProperty(name = "studentId", example = "23030001", notes = "학생 아이디", required = true)
    private String studentId;
    @ApiModelProperty(name = "studentImgURL", example = "/file/student/dsafg3476sdvb.jpg", notes = "학생 사진", required = true)
    private String imgURL;
    @ApiModelProperty(name = "examNo", example = "1", notes = "시험의 DB상의 시퀀스 번호", required = true)
    private Integer examNo;
    @ApiModelProperty(name = "examName", example = "3월 1주차 주간 시험", notes = "시험 이름", required = true)
    private String examName;
    @ApiModelProperty(name = "classNo", example = "1", notes = "반의 DB상의 시퀀스 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "className", example = "기초 강화 A반", notes = "반 이름", required = true)
    private String className;
    @ApiModelProperty(name = "score", example = "77", notes = "학생 점수 (NULL인 경우 입력 데이터 없음)", required = true)
    private Integer score;
    @ApiModelProperty(name = "examDt", example = "2023-03-07", notes = "시험일", required = true)
    private String examDt;
}
