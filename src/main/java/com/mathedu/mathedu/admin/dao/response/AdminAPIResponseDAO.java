package com.mathedu.mathedu.admin.dao.response;

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
public class AdminAPIResponseDAO {
    private Boolean status;
    private String message;
    @JsonIgnore
    private HttpStatus code;
}
