package com.javatechie.repository.RepositoryCustom;

import com.javatechie.entity.StoreEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface StoreRepositoryCustom {
    List<StoreEntity> filterStore(String storeName, Pageable pageable);
    Long countTotalElement(String storeName);
}
