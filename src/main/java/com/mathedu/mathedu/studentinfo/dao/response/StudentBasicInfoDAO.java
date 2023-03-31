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
public class StudentBasicInfoDAO {
    @ApiModelProperty(name = "name", example = "김학생", notes = "학생 이름", required = true)
    private String name;
    @ApiModelProperty(name = "profileImgURL", example = "/file/student/sdnh3j87sdfnweuht.jpg", notes = "사진", required = true)
    private String profileImgURL;
    @ApiModelProperty(name = "birth", example = "2014-03-02", notes = "생일", required = true)
    private String birth;
    @ApiModelProperty(name = "phone", example = "010-1234-1234", notes = "전화번호", required = true)
    private String phone;
    @ApiModelProperty(name = "className", example = "기초 강화 A반", notes = "반 이름", required = true)
    private String className;
    @ApiModelProperty(name = "school", example = "그린초등학교", notes = "학교 명", required = true)
    private String school;
    @ApiModelProperty(name = "id", example = "23030001", notes = "학생 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "alternatePhone", example = "010-2345-8494", notes = "보호자 전화번호", required = true)
    private String alternatePhone;
    @ApiModelProperty(name = "classDays", example = "월, 수, 금", notes = "수업 요일", required = true)
    private String classDays;
    @ApiModelProperty(name = "starttime", example = "18:30", notes = "수업 시작 시간", required = true)
    private String starttime;
    @ApiModelProperty(name = "endtime", example = "20:30", notes = "수업 종료 시간", required = true)
    private String endtime;
    @ApiModelProperty(name = "grade", example = "3", notes = "학년", required = true)
    private Integer grade;
    @ApiModelProperty(name = "regDt", example = "2023-03-01", notes = "등록일", required = true)
    private String regDt;
    @ApiModelProperty(name = "address", example = "대구광역시 중구 중앙대로 394", notes = "학생 주소", required = true)
    private String address;
    @ApiModelProperty(name = "teacher", example = "김선생", notes = "선생님 이름", required = true)
    private String teacher;
}
