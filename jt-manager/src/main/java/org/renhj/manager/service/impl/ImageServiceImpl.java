package org.renhj.manager.service.impl;

import org.apache.log4j.Logger;
import org.renhj.manager.service.ImageService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;


@Service
public class ImageServiceImpl implements ImageService {

    private static final String host = "image.renhj.com";
    private static final String root = "D:/image";
    private static final List<String> list = new ArrayList<>();
    private static final Logger log = Logger.getLogger(ImageServiceImpl.class);

    public ImageServiceImpl() {
        list.add(".jpg");
        list.add(".png");
        list.add(".gif");
    }

    @Override
    public HashMap addImage(MultipartFile image) {
        HashMap<String, String> result = new HashMap<String, String>();
        // 1、获取文件名
        String fileName = image.getOriginalFilename();
        // 2、文件名后缀
        String fileSuffix = null;
        if (fileName != null) {
            fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            log.info("获取文件后缀： " + fileSuffix);
        }
        // 3、检查是否是正确的图片
        if (!isImage(image)) {
            log.info("图片格式不正确： " + fileSuffix);
            result.put("error", "1");
            result.put("message", "图片格式不正确！");
            return result;
        }
        // 4、准备存储路径
        String imageDir = new SimpleDateFormat("/yyyy/MM/dd/HH/mm/").format(new Date());
        String imageName = String.valueOf(UUID.randomUUID()) + fileSuffix;
        String imagePath = root + imageDir + imageName;

        // 6、写入文件
        try {
            File file = new File(root + imageDir);
            if (!file.exists()) {
                file.mkdirs();
            }
            image.transferTo(new File(imagePath));
            log.info("写入磁盘： " + imagePath);
        } catch (IOException e) {
            e.printStackTrace();
            log.info("写入磁盘失败!");
            result.put("error", "2");
            result.put("message", "写入磁盘失败！");
            result.put("reason", e.getMessage());
            return result;
        }
        // 7、准备网络路径
        String url = "///" + host + imageDir + imageName;
        // 8、返回数据
        result.put("filename", image.getOriginalFilename());
        result.put("url", url);
        result.put("path", imagePath);
        result.put("width", "200");
        result.put("height", "200");
        return result;
    }

    private boolean isImage(MultipartFile image) {
        if (image == null) {
            return false;
        }
        try {
            String fileName = image.getOriginalFilename();
            String fileSuffix = null;
            if (fileName != null) {
                fileSuffix = fileName.substring(fileName.lastIndexOf(".") + 1);
            }
            System.out.println(fileSuffix);
            if (list.contains(fileSuffix)) {
                return false;
            }
            BufferedImage bufferedImage = ImageIO.read(image.getInputStream());
            return bufferedImage.getHeight() > 0 && bufferedImage.getWidth() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
