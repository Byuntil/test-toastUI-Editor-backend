package toast.backend.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class ToastEntity {

    @Id @GeneratedValue
    private Long id;

    private String contentMarkdown;

    @Builder
    public ToastEntity(Long id, String contentMarkdown) {
        this.id = id;
        this.contentMarkdown = contentMarkdown;
    }

    public ToastEntity() {

    }
}
