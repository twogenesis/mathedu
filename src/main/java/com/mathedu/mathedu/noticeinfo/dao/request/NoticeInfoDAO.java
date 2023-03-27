package com.mathedu.mathedu.noticeinfo.dao.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeInfoDAO {
    private Integer no;
    private String title;
    private String content;
    private Integer teacherNo;
    private Integer classNo;
    private String category;
}
