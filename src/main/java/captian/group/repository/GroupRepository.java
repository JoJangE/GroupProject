package captian.group.repository;

import captian.group.domain.Group;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
public class GroupRepository {
    private final EntityManager em;

    public void save(Group group) {
        em.persist(group);
    }

    public Group findOne(Long id) {
        return em.find(Group.class, id);
    }
}
