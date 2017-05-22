package com.zkn.learnspringboot.web.controller;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by wb-zhangkenan on 2017/5/22.
 *
 * @author wb-zhangkenan
 * @date 2017/05/22
 */
@Controller
@RequestMapping("/uploadAndDownload")
public class UploadAndDownloadFileController {

    @RequestMapping("/index")
    public String index() {

        return "uploadAndDownload";
    }

    @RequestMapping(value = "/uploadFileAction", method = RequestMethod.POST)
    public ModelAndView uploadFileAction(@RequestParam("uploadFile") MultipartFile uploadFile, @RequestParam("id") Long id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("uploadAndDownload");
        try {
            InputStream fis = uploadFile.getInputStream();
            System.out.println(fis.toString() + " " + id);
            modelAndView.addObject("sucess", "上传成功");
            return modelAndView;
        } catch (IOException e) {
            e.printStackTrace();
        }
        modelAndView.addObject("sucess", "上传失败!");
        return modelAndView;
    }

}