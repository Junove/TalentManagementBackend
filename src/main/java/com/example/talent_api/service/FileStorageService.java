package com.example.talent_api.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileStorageService {

    private static final Logger logger = LoggerFactory.getLogger(FileStorageService.class);

    @Value("${app.upload.dir}")
    private String uploadDir;

    public String storeFile(MultipartFile file) throws IOException {
        try {
            Path uploadPath = Paths.get(uploadDir).toAbsolutePath().normalize();
            logger.info("Upload path: {}", uploadPath);

            Files.createDirectories(uploadPath);

            String fileName = file.getOriginalFilename();
            Path filePath = uploadPath.resolve(fileName);
            logger.info("Saving file to: {}", filePath);

            Files.copy(file.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);

            logger.info("File saved successfully: {}", filePath);
            return filePath.toString();
        } catch (IOException e) {
            logger.error("Failed to store file", e);
            throw new IOException("Could not store file " + file.getOriginalFilename(), e);
        }
    }
}