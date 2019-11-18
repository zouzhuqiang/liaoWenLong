package com.lwl.advertising.controller;

import com.lwl.advertising.service.AdvertisingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
@RequestMapping("/UploadController")
public class UploadController {
    //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "src//main//resources//static//file//";

    @Autowired
    private AdvertisingService advertisingService;

    @GetMapping("/toUpload")
    public String index() {
        return "fileupload/upload";
    }

    @PostMapping("/upload") // //new annotation since 4.3
    public String singleFileUpload(@RequestParam("file") MultipartFile file,
                                   RedirectAttributes redirectAttributes,String client) {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            return "redirect:uploadStatus";
        }

        try {
            // Get the file and save it somewhere
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
            Files.write(path, bytes);
            redirectAttributes.addFlashAttribute("message",
                    "You successfully uploaded '" + file.getOriginalFilename() + "'");
            advertisingService.advertisingAdd(file.getOriginalFilename(),client);
            System.out.println(file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "redirect:/UploadController/uploadStatus";
    }

    @GetMapping("/uploadStatus")
    public String uploadStatus() {
        return "fileupload/uploadStatus";
    }

}