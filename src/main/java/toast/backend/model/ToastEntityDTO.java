package toast.backend.model;

import lombok.*;

@Getter
public class ToastEntityDTO {
    private Long id;
    private String content;

    @Builder
    public ToastEntityDTO(Long id, String content) {
        this.id = id;
        this.content = content;
    }

    public ToastEntityDTO() {
    }

    public static ToastEntity toEntity(final ToastEntityDTO dto){
        return ToastEntity.builder()
                .id(dto.getId())
                .contentMarkdown(dto.getContent())
                .build();
    }
}
