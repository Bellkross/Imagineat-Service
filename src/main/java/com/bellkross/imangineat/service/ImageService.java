package com.bellkross.imangineat.service;

import com.bellkross.imangineat.respository.RestaurantPhotoRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

@Service
public class ImageService {

    private static final String UPLOAD_ROOT = "upload-dir";

    public byte[] findImage(String path) throws IOException {

        InputStream is = getClass().getClassLoader().getResourceAsStream(String.format("%s\\%s.jpg", UPLOAD_ROOT, path));

        if (Objects.isNull(is)) {
            throw new IllegalArgumentException("Incorrect path");
        }

        return IOUtils.toByteArray(is);
    }

}
