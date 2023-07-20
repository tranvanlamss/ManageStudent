package com.javatechie.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreDTO {
    String id;
    String nameStore;
    String ownerName;
    private MultipartFile avatar;
    private List<MultipartFile> imagesDescription;
}
