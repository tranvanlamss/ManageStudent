package com.javatechie.service;

import com.javatechie.entity.Media;
import com.javatechie.repository.MediaRepository;
import com.javatechie.response.IpfsResp;
import com.javatechie.util.IdUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

@Service
public class MediaService {

    static final Logger logger = LoggerFactory.getLogger(MediaService.class);

    @Autowired
    private FileService fileService;

    @Autowired
    private MediaRepository mediaRepo;

    public Media addIpfs(MultipartFile file, String folderName, String createrId) {

        IpfsResp info = fileService.addIpfs(file);
        if (info == null || (info.getHash() == null && info.getMessage() == null)) {
            logger.error("Create media file fail.");
            return null;
        }
        String hash = info.getHash();
        String path = fileService.saveLocalStorage(file, folderName);

        logger.info("Return {}, {}, {}", info.getName(), hash, info.getSize());
        Media media = new Media();
        media.setId(IdUtil.generate());
        media.setName(file.getOriginalFilename());
        media.setHash(hash);
        media.setStorageType("IPFS");
        media.setSize(info.getSize());
        media.setPath(path);
        media.setType(file.getContentType());
        media.setCreatedTime(LocalDateTime.now());
        media.setCreaterId(createrId);
        mediaRepo.save(media);
        return media;
    }

    public Media addIpfs(BufferedImage bufferedImage, String fileName, String contentType, String createrId) {
        IpfsResp info = fileService.addIpfs(bufferedImage, fileName);
        if (info == null || (info.getHash() == null && info.getMessage() == null)) {
            logger.error("Create media file fail.");
            return null;
        }
        String hash = info.getHash();

        logger.info("Return {}, {}, {}", info.getName(), hash, info.getSize());

        Media media = new Media();
        media.setId(IdUtil.generate());
        media.setName(fileName);
        media.setHash(hash);
        media.setStorageType("IPFS");
        media.setSize(info.getSize());
        media.setType(contentType);
        media.setCreatedTime(LocalDateTime.now());
        media.setCreaterId(createrId);
        return media;
    }

    public Media saveLocalStorage(MultipartFile file, String folderName, String createrId) {
        if (file == null || file.isEmpty()) {
            return null;
        }
        String path = fileService.saveLocalStorage(file, folderName);

        Media media = new Media();
        media.setName(file.getOriginalFilename());
        media.setSize(file.getSize());
        media.setType(file.getContentType());
        media.setPath(path);
        media.setStorageType("LOCAL");
        media.setCreatedTime(LocalDateTime.now());
        media.setCreaterId(createrId);
        media = mediaRepo.save(media);

        return media;
    }
}
