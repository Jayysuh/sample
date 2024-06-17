package com.GLAB30991.FileUploadExample;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@Service
public class FileService {
    //path to the upload dir, Change it as per your computer
    public String uploadDir = "C:\\Users\\Learner_9ZH3Z175\\Desktop\\Spring\\GLAB309.9.1\\uploads";
    public void uploadFile(MultipartFile file) {
        try {
            Path copyLocation = Paths.get(uploadDir + File.separator + StringUtils.cleanPath(file.getOriginalFilename()));
            Files.copy(file.getInputStream(), copyLocation, StandardCopyOption.REPLACE_EXISTING);
            String fileName = file.getOriginalFilename();
            int filelength = file.getBytes().length;
            System.out.println("File uploaded successfully, " + "file name is :: "+ fileName + " and length is ::" + filelength);
        } catch (IOException e) {
            e.printStackTrace();
            throw new FileStorageException("File Not Found");
        }
    }
}
/*
@Service is a specialization of the @Component annotation. It tells
Spring that this is a service class. Typically all the business logic is written
in this layer.

We have a public method uploadFile which takes in a MultipartFile as an
argument.
We then created the full Path of the file by using the Paths class
provided by Java.
StringUtils.cleanPath is used to clean the path and we simply append uploadDir to it using a File.separator.
Always use utility methods to handle paths in code because it will automatically handle different OS implementations.
For example, in Windows, the file separator is \ while in Linux it’s /.

If there is an Exception in this whole process, we capture it and throw a
custom FileStorageException exception.
 */