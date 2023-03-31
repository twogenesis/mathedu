package com.mathedu.mathedu.classinfo.dao.response;

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
public class ClassSummaryInfoDAO {
    @ApiModelProperty(name = "classNo", example = "1", notes = "반의 DB상의 시퀀스 번호", required = true)
    private Integer classNo;
    @ApiModelProperty(name = "name", example = "수학 기초 A반", notes = "반 이름", required = true)
    private String name;
    @ApiModelProperty(name = "days", example = "월, 수, 금", notes = "수업 요일", required = true)
    private String days;
    @ApiModelProperty(name = "opendt", example = "2023-03-01 00:00:00", notes = "개강일", required = true)
    private Date opendt;
    @ApiModelProperty(name = "closedt", example = "2023-03-31 00:00:00", notes = "종강일", required = true)
    private Date closedt;
}
