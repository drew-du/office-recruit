package com.eqxiu.office.recruit.controller;

import com.eqxiu.office.recruit.service.IRecruitService;
import com.eqxiu.office.recruit.service.bean.ReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@RestController
public class IndexController {

    @Autowired
    private String filePath;

    @Autowired
    private IRecruitService recruitService;

    @RequestMapping(path="/recruit/api", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String api(@RequestBody String request){
        return recruitService.exec(ReqBean.parseReqBean(request)).toJsonString();
    }

    @RequestMapping(path="/recruit/upload", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file){
        if (file == null || file.isEmpty()){
            return "upload file fail";
        }
        try {
            String fileName = file.getOriginalFilename();
            File localFile = new File(filePath + fileName);
            file.transferTo(localFile);
            return "upload file success";
        } catch (IOException e) {
            e.printStackTrace();
            return "upload file fail";
        }
    }


}
