package com.javatechie.service.Impl;

import com.javatechie.dto.StoreDTO;
import com.javatechie.entity.StoreEntity;
import com.javatechie.repository.RepositoryCustom.StoreRepositoryCustom;
import com.javatechie.repository.StoreRepository;
import com.javatechie.response.MessageResponse;
import com.javatechie.service.StoreService;
import com.javatechie.util.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StoreServiceImpl implements StoreService {
    private final StoreRepository storeRepository;

    private final StoreRepositoryCustom storeRepositoryCustom;

    public StoreServiceImpl(StoreRepository storeRepository, StoreRepositoryCustom storeRepositoryCustom) {
        this.storeRepository = storeRepository;
        this.storeRepositoryCustom = storeRepositoryCustom;
    }

    @Override
    public MessageResponse createStore(StoreDTO storeDTO) {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setNameStore(storeDTO.getNameStore());
        storeEntity.setOwnerName(UserUtil.getUserName());
        storeRepository.save(storeEntity);
        return MessageResponse.ok(storeEntity);
    }

    @Override
    public MessageResponse filterStore(String storeName, Integer page , Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        List<StoreEntity> list = storeRepositoryCustom.filterStore(storeName, pageable);
        Long totalElement = storeRepositoryCustom.countTotalElement(storeName);
        Long totalPages = (totalElement + size - 1) / size;

        MessageResponse messageResponse = new MessageResponse();
        messageResponse.setResponseCode("SUCCESS");
        messageResponse.setPage(page);
        messageResponse.setSize(size);
        messageResponse.setResult(list);
        messageResponse.setTotalElement(totalElement);
        messageResponse.setTotalPage(totalPages);
        return messageResponse;
    }
}
