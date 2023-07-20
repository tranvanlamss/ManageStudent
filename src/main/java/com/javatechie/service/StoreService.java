package com.javatechie.service;

import com.javatechie.dto.StoreDTO;
import com.javatechie.response.MessageResponse;

public interface StoreService {
    MessageResponse createStore(StoreDTO storeDTO);

    MessageResponse filterStore(String storeName, Integer page , Integer size);
}
