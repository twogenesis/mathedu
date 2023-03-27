package com.mathedu.mathedu.noticeinfo.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeInsertDAO {
    private String title;
    private String category;
    private String content;
    private Integer teacherNo;
    private Integer classNo;
    private MultipartFile[] files;
}
