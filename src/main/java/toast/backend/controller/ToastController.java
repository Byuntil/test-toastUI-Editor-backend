package toast.backend.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import toast.backend.model.ResponseDTO;
import toast.backend.model.ToastEntity;
import toast.backend.model.ToastEntityDTO;
import toast.backend.service.ToastService;

@RestController
@Slf4j
@RequestMapping("/toast")
public class ToastController {
    @Autowired
    private ToastService toastService;

    //MariaDB에 Editor에 저장되어있던 markdown 저장
    @PostMapping("/submit")
    public ResponseEntity toastSave(@RequestBody ToastEntityDTO toast) {
        try {
            ToastEntity entity = ToastEntityDTO.toEntity(toast);
            log.info("어떤것이 들어왔니?? markdown={}", entity.getContentMarkdown());
            //todo: 기존에 있던 이미지 URL 배열과 새로 들어온 이미지링크랑 비교해서 없는 URL 삭제
            Long id = toastService.saveToast(entity);
            ResponseDTO response = ResponseDTO.builder().id(id).build();
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            String error = e.getMessage();
            ResponseDTO response = ResponseDTO.builder().error(error).build();
            return ResponseEntity.badRequest().body(response);
        }
    }

    // 나중에 여러 내용 받아올수 있게 구현

    @GetMapping()
    public ToastEntityDTO toastReturn(@RequestParam("id") Long id){
        ToastEntity content = toastService.findContent(id);
        log.info("어떤것이 들어왔니?? id={}", id);
        log.info("어떤것을 찾았니? id={}, content={}", content.getId(), content.getContentMarkdown());
        return ToastEntityDTO.builder().id(id).content(content.getContentMarkdown()).build();
    }
}
