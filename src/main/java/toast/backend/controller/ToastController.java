package toast.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import toast.backend.model.ToastEntity;
import toast.backend.model.ToastEntityDTO;
import toast.backend.service.ToastService;

@RestController
@Slf4j
public class ToastController {
    @Autowired
    private ToastService toastService;

    //MariaDB에 Editor에 저장되어있던 markdown 저장
    @PostMapping("/submit")
    public String testControllerRequestBody(@RequestBody ToastEntityDTO toast) {
        ToastEntity entity = ToastEntityDTO.toEntity(toast);
        log.info("어떤것이 들어왔니?? markdown={}", entity.getContentMarkdown());
        //todo: 기존에 있던 이미지 URL 배열과 새로 들어온 이미지링크랑 비교해서 없는 URL 삭제
        toastService.saveToast(entity);
        return "OK"; //나중에 상태같은거 추가 하기
    }
}
