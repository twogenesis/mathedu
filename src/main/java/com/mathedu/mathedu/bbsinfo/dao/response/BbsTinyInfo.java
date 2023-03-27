package com.mathedu.mathedu.bbsinfo.dao.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BbsTinyInfo {
    private Integer no;
    private String title;
}
