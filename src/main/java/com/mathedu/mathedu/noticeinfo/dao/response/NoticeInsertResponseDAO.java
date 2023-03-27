package com.mathedu.mathedu.noticeinfo.dao.response;

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
public class NoticeInsertResponseDAO {
    private Boolean status;
    private Integer noticeNo;
    private String message;
    @JsonIgnore
    private HttpStatus code;
}
