package com.fc.controller;


import com.fc.service.FileService;
import com.fc.vo.ResultVo;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("")
public class FileController {
    @Autowired
    private FileService fileService;

    @PostMapping("uploadImg")
    public ResultVo upload(MultipartFile file) {

    return fileService.upload(file);
    }
}
