package com.GLAB30991.FileUploadExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.Arrays;

@Controller
public class FileController {

    @Autowired
    FileService fileService;

    @GetMapping("/")
    public String indexPage() {
        return "upload";
    }
    @PostMapping("/uploadFile")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) throws IOException {
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload.");
            return "redirect:/";
        }
        else {
            fileService.uploadFile(file);
            redirectAttributes.addFlashAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!, file.");
            return "redirect:/";
        }
    }

    //For uploading multiple files
    @PostMapping("/uploadFiles")
    public String uploadFiles(@RequestParam("files") MultipartFile[] files, RedirectAttributes redirectAttributes) {
        Arrays.asList(files)
                .stream()
                .forEach(file -> fileService.uploadFile(file));
        redirectAttributes.addFlashAttribute("message", "You successfully uploaded all files!");
        return "redirect:/";
    }
}
/*
 @Controller annotation is also a specialization of @Component
annotation. It makes a class accept the HTTP request and respond
accordingly. It also takes care of the various conversion of request
payload to an internal data structure.

Next we @Autowired the FileService bean so that we can use its
uploadFile method.

Then we have a simple GetMapping at / which will simply return String
upload. Being a controller class Spring will search for upload.html
and serve it to the browser.

Next, we have a PostMapping of /uploadFile, which has a
RequestParam of MultipartFile which is an object that has our file
and its metadata details.

We then used the FileService uploadFile method to upload the file.
RedirectAttributes is a specialization of Spring Model interface that
is used to select attributes for a redirect scenario.

If the above operation is successful, we set the success message in
redirectAttributes and redirect to the same page.
 */