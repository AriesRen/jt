package org.renhj.manager.controller;

import org.renhj.common.pojo.vo.Result;
import org.renhj.manager.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("/images")
@CrossOrigin(origins = "*")
public class ImageController {
    private final ImageService imageService;

    @Autowired
    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping
    public Map<?,?> uploadImages(MultipartFile image) {
        return imageService.addImage(image);
    }

    @DeleteMapping
    public Result deleteImages(@RequestParam String urls){
        try {
            imageService.deleteImages(urls);
            return Result.ok("delete ok");
        }catch (Exception e){
            e.printStackTrace();
            return Result.build(500, "未知错误！", null);
        }
    }

}
