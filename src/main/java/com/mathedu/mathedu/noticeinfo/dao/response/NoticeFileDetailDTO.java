package com.mathedu.mathedu.noticeinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class NoticeFileDetailDTO {
    private String fileName;
    private String fileType;
    private String downloadURL;
}
