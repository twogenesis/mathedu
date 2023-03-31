package com.mathedu.mathedu.teacherinfo.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
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
public class TeacherClassListResponseDAO {
    @ApiModelProperty(name = "status", example = "true", notes = "상태 값", required = true)
    private Boolean status;
    @ApiModelProperty(name = "message", example = "반 리스트를 조회하였습니디.", notes = "상태 메시지", required = true)
    private String message;
    @ApiModelProperty(name = "classList", notes = "반 정보 객체 리스트", required = true)
    private List<TeacherClassTinyInfoDAO> classList;
    @JsonIgnore
    private HttpStatus code;
}
