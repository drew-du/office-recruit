package com.eqxiu.office.recruit.controller;

import com.eqxiu.office.recruit.service.IRecruitService;
import com.eqxiu.office.recruit.service.bean.ReqBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

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

    @RequestMapping(path="/recruit/test")
    public String test(){
        try {
            InputStream inputStream = IndexController.class.getResourceAsStream("/test-page.html");
            StringBuilder sb = new StringBuilder();
            byte[] bytes = new byte[1024];
            while(inputStream.read(bytes) != -1){
                sb.append(new String(bytes, StandardCharsets.UTF_8));
            }
            return sb.toString();
        } catch (IOException e){
            e.printStackTrace();
            return "the page you are looking for flew away, haha";
        }

    }

}
