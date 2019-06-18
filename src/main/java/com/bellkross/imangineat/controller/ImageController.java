package com.bellkross.imangineat.controller;

import com.bellkross.imangineat.service.ImageService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.IMAGE_JPEG_VALUE;

@RestController
public class ImageController {

    private final ImageService imageService;

    public ImageController(ImageService imageService) {
        this.imageService = imageService;
    }

    @RequestMapping(value = "api/image/{path}", produces = IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable String path) throws IOException {

        return imageService.findImage(path);
    }

}
