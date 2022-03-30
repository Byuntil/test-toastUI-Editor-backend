package toast.backend.model;

import lombok.*;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ToastEntityDTO {
    private String content;

    public static ToastEntity toEntity(final ToastEntityDTO dto){
        return ToastEntity.builder()
                .contentMarkdown(dto.getContent())
                .build();
    }
}
