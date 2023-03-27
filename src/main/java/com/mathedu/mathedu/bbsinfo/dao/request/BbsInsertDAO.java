package com.mathedu.mathedu.bbsinfo.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsInsertDAO {
    private String title;
    private String category;
    private String content;
    private Integer teacherNo;
    private Integer classNo;
    private MultipartFile[] files;
}
