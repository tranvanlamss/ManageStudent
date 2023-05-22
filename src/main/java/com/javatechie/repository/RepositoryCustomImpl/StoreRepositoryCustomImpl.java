package com.javatechie.repository.RepositoryCustomImpl;

import com.javatechie.entity.StoreEntity;
import com.javatechie.repository.RepositoryCustom.StoreRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StoreRepositoryCustomImpl implements StoreRepositoryCustom {
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<StoreEntity> filterStore(String storeName, Pageable pageable) {
        StringBuilder sql = new StringBuilder("SELECT * FROM store WHERE 1 = 1");

        if (storeName != null && !storeName.isEmpty()) {
            sql.append(" AND store_name LIKE %:storeName%");
        }

        Query query = entityManager.createNativeQuery(sql.toString(), StoreEntity.class);

        if (storeName != null && !storeName.isEmpty()) {
            query.setParameter("store_name", storeName);
        }

        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        return query.getResultList();
    }

    @Override
    public Long countTotalElement(String storeName) {
        StringBuilder sql = new StringBuilder("SELECT COUNT(*) FROM store WHERE 1 = 1");

        if (storeName != null && !storeName.isEmpty()) {
            sql.append(" AND store_name LIKE %:storeName%");
        }

        Query query = entityManager.createNativeQuery(sql.toString());

        if (storeName != null && !storeName.isEmpty()) {
            query.setParameter("store_name", storeName);
        }

        return ((Number) query.getSingleResult()).longValue();
    }
}
