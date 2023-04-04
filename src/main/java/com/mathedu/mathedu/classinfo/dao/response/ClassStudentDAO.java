package com.mathedu.mathedu.classinfo.dao.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClassStudentDAO {
    @ApiModelProperty(name = "no", example = "1", notes = "학생의 DB상의 시퀀스번호", required = true)
    private Integer no;
    @ApiModelProperty(name = "id", example = "23030001", notes = "학생의 아이디", required = true)
    private String id;
    @ApiModelProperty(name = "img", example = "/file/student/asjkhgw34sdgh.jpg", notes = "학생 사진", required = true)
    private String img;
    @ApiModelProperty(name = "name", example = "김학생", notes = "학생 이름", required = true)
    private String name;
    @ApiModelProperty(name = "phone", example = "010-4356-5368", notes = "학생 전화번호", required = true)
    private String phone;
    @ApiModelProperty(name = "alternatephone", example = "010-3498-7655", notes = "보호자 전화번호", required = true)
    private String alternatephone;
    @ApiModelProperty(name = "address", example = "대구광역시 중구 중앙대로 394", notes = "주소", required = true)
    private String address;
}
