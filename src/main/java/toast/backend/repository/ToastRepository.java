package toast.backend.repository;

import org.springframework.stereotype.Repository;
import toast.backend.model.ToastEntity;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class ToastRepository {
    @PersistenceContext
    private EntityManager em;

    public void save(ToastEntity toast){
        em.persist(toast);
    }

    public ToastEntity findOne(Long id){
        return em.find(ToastEntity.class, id);
    }
}
