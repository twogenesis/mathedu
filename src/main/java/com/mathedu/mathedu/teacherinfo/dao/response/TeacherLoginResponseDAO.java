package com.mathedu.mathedu.teacherinfo.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TeacherLoginResponseDAO {
    private Boolean status;
    private String message;
    private TeacherSummaryDAO teacher;
    @JsonIgnore
    private HttpStatus code;

}
