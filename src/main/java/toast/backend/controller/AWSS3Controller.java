package toast.backend.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import toast.backend.service.FileUploadService;

@RestController
@RequestMapping("/s3")
@RequiredArgsConstructor
@Slf4j
public class AWSS3Controller {
    private final FileUploadService fileUploadService;

    //이미지 업로드
    @PostMapping("/upload")
    public String uploadImage(@RequestPart MultipartFile file){
        log.info("이미지 파일 어떤것이 들어왔나?? fileName = {}",file.getName());
        String url = fileUploadService.uploadImage(file);
        log.info("S3에 저장되고 나온 이미지 url = {}",url);
        return url;
    }
}
