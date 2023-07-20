package com.javatechie.service.Impl;

import com.javatechie.common.Constants;
import com.javatechie.dto.StoreDTO;
import com.javatechie.entity.Media;
import com.javatechie.entity.ObjectMedia;
import com.javatechie.entity.StoreEntity;
import com.javatechie.entity.UserEntity;
import com.javatechie.common.enumerate.ObjectRefTypeEnum;
import com.javatechie.common.enumerate.ObjectTypeEnum;
import com.javatechie.exception.InputInvalidException;
import com.javatechie.repository.MediaRepository;
import com.javatechie.repository.ObjectMediaRepository;
import com.javatechie.repository.RepositoryCustom.StoreRepositoryCustom;
import com.javatechie.repository.StoreRepository;
import com.javatechie.repository.UserRepository;
import com.javatechie.response.MessageResponse;
import com.javatechie.service.MediaService;
import com.javatechie.service.StoreService;
import com.javatechie.util.UserUtil;
import com.javatechie.util.ValidateUtil;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StoreServiceImpl implements StoreService {

    @Autowired
    private MediaService mediaService;

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ObjectMediaRepository objectMediaRepository;
    private final StoreRepository storeRepository;

    private final StoreRepositoryCustom storeRepositoryCustom;

    public StoreServiceImpl(StoreRepository storeRepository, StoreRepositoryCustom storeRepositoryCustom) {
        this.storeRepository = storeRepository;
        this.storeRepositoryCustom = storeRepositoryCustom;
    }

    @Transactional
    @Override
    public MessageResponse createStore(StoreDTO storeDTO) {
        StoreEntity storeEntity = new StoreEntity();
        storeEntity.setNameStore(storeDTO.getNameStore());
        storeEntity.setOwnerName(getUserId());
        if (storeDTO.getAvatar() != null && !ValidateUtil.isEmpty(storeDTO.getAvatar())) {
            createAvatar(storeDTO);
        }
        storeRepository.save(storeEntity);
        return MessageResponse.ok("create store successfully");
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


    public void createAvatar(StoreDTO payload){
        Media media = mediaService.addIpfs(payload.getAvatar(), Constants.FOLDER_STORE_IMAGE, getUserId());
        media = mediaRepository.save(media);
        ObjectMedia objectMe = new ObjectMedia();
        objectMe.setMediaId(media.getId());
        objectMe.setObjectId(getUserId());
        objectMe.setObjectType(ObjectTypeEnum.STORE.name());
        objectMe.setRefType(ObjectRefTypeEnum.AVATAR_STORE.name());
        objectMediaRepository.save(objectMe);

    }
    private String getUserId(){
        Optional<UserEntity> user = userRepository.findByUsername(UserUtil.getUserName());
        if (!user.isPresent()){
            throw new InputInvalidException("Not found user Id");
        }
        return user.get().getId();
    }
}
