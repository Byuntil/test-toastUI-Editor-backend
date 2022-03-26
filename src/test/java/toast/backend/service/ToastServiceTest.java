package toast.backend.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import toast.backend.model.ToastEntity;
import toast.backend.repository.ToastRepository;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ToastServiceTest {
    @Autowired
    ToastService toastService;
    @Autowired
    ToastRepository toastRepository;

    @Test
    public void DB저장 () throws Exception {
        //given
        ToastEntity toastEntity = ToastEntity.builder().
                contentHtml("<h1>vblal</h1>").build();
        //when
        Long savedId = toastService.saveToast(toastEntity);
        //then
        Assertions.assertThat(toastEntity.getContentHtml()).isEqualTo(toastRepository.findOne(savedId).getContentHtml());
    }
}