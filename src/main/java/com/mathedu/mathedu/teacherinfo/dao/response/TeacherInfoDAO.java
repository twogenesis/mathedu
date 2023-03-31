package com.mathedu.mathedu.teacherinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherInfoDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "선생님의 DB상의 시퀀스 번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "id", example = "teacher1", notes = "선생님 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "imageURL", example = "/file/student/dsfghu324sdgh.jpg", notes = "선생님 사진", required = true)
    private String imageURL;
    @ApiModelProperty(name = "status", example = "1", notes = "사용상태 (1:정상, 2:정지)", required = true)
    private String status;
    @ApiModelProperty(name = "regdt", example = "2023-03-01 00:00:00", notes = "등록 시간", required = true)
    private Date regdt;
    @ApiModelProperty(name = "name", example = "김선생", notes = "선생님이름", required = true)
    private String name;
}
