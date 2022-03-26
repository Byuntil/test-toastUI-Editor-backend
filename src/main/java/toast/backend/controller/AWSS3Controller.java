package toast.backend.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import toast.backend.service.FileUploadService;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
public class AWSS3Controller {
    private final FileUploadService fileUploadService;

    //이미지 업로드
    @PostMapping("/upload")
    public String uploadImage(@RequestPart MultipartFile file){
        return fileUploadService.uploadImage(file);
    }
}
