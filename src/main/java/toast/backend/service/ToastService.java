package toast.backend.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toast.backend.model.ToastEntity;
import toast.backend.repository.ToastRepository;

@Service
@RequiredArgsConstructor
public class ToastService {

    private final ToastRepository toastRepository;

    @Transactional
    public Long saveToast(ToastEntity toast){
        toastRepository.save(toast);
        return toast.getId();
    }

    public ToastEntity findContent(Long id){
        return toastRepository.findOne(id);
    }
}
