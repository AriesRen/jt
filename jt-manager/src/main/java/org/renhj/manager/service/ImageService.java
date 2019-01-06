package org.renhj.manager.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;

public interface ImageService {
    HashMap addImage(MultipartFile image);
}
