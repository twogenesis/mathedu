package com.mathedu.mathedu.bbsinfo.dao.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BbsInsertResponseDAO {
    private Boolean status;
    private Integer bbsNo;
    private String message;
    @JsonIgnore
    private HttpStatus code;
}
