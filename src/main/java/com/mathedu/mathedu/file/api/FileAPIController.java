package com.mathedu.mathedu.file.api;

import com.mathedu.mathedu.file.service.FileService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FileAPIController {
    private final FileService fileService;
    @GetMapping("/file/{type}/{filename}")
    public ResponseEntity<Resource> getFile(@PathVariable String type, @PathVariable String filename) throws Exception {
        return fileService.getFile(type, filename);
    }

}
