package com.mathedu.mathedu.teacherinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder


public class TeacherDetailInfoResponseDAO {

    @ApiModelProperty(name = "id", example = "teacher001", notes = "선생님 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "name", example = "선생님1", notes = "선생님 이름", required = true)
    private String name;
    @ApiModelProperty(name = "imageURL", example = "/file/teacher/hewwe347dsfh.jpg", notes = "선생님 사진", required = true)
    private String imageURL;
    @ApiModelProperty(name = "status", example = "1", notes = "사용 상태 (1:정상사용, 2:정지)", required = true)
    private String status;
    @ApiModelProperty(name = "regdt", example = "2023-03-01 00:00:00", notes = "선생님 등록시간", required = true)
    private Date regdt;
    @ApiModelProperty(name = "totalStuPage", example = "3", notes = "학생 리스트 총 페이지 수", required = true)
    private Integer totalStuPage;
    @ApiModelProperty(name = "totalStuCount", example = "23", notes = "담당 학생 수", required = true)
    private Integer totalStuCount;
    @ApiModelProperty(name = "currentStuPage", example = "1", notes = "현재 페이지", required = true)
    private Integer currentStuPage;
    @ApiModelProperty(name = "stuList", notes = "담당 학생 리스트", required = false)
    private List<TeacherStudentInfoDAO> stuList;

}
