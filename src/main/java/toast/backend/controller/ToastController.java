package toast.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import toast.backend.model.ToastEntity;
import toast.backend.service.ToastService;

@RestController
public class ToastController {
    @Autowired
    private ToastService toastService;
    
    @PostMapping("/submit")
    public String testContorllerRequestBody(@RequestBody ToastEntity toast) {
        toastService.saveToast(toast);
        return "redirect:/";
    }
}
