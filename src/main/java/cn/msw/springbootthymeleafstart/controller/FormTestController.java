package cn.msw.springbootthymeleafstart.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @Author 毛送文
 * @Date 2021/1/20 20:09
 * @Version 1.0
 */
@Slf4j
@Controller
public class FormTestController {
    @GetMapping("/form_layouts")
    public String form_layouts(){
        return "form/form_layouts";
    }

    /**
     *
     * @param email
     * @param username
     * @param headImg
     * @param lifePhoto
     * @return
     */
    @RequestMapping("/upload")
    public String upload(@RequestParam("email") String email,
                         @RequestParam("username") String username,
                         @RequestPart("headImg") MultipartFile headImg,
                         @RequestPart("lifePhoto") MultipartFile[] lifePhoto){

        log.info("上传的信息是:email={},username={},headImg={},lifePhoto={}",
                 email,username,headImg.getSize(),lifePhoto.length);
        if(!headImg.isEmpty()){
            String originalFilename = headImg.getOriginalFilename();
            String fileName=UUID.randomUUID().toString().replace("-","")+"_"+originalFilename;
            try {
                headImg.transferTo(new File("D:\\upload\\"+fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(lifePhoto.length>0){
            for (MultipartFile multipartFile : lifePhoto) {
                if(!multipartFile.isEmpty()){
                    String originalFilename = multipartFile.getOriginalFilename();
                    String fileName=UUID.randomUUID().toString().replace("-","")+"_"+originalFilename;
                    try {
                        multipartFile.transferTo(new File("D:\\upload\\life\\"+fileName));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return "main";

    }
}
