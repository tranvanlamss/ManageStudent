package com.javatechie.service;

import com.javatechie.config.IpfsProperties;
import com.javatechie.response.IpfsResp;
import com.javatechie.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;

@Service
public class FileService {
    static final Logger logger = LoggerFactory.getLogger(FileService.class);

    @Autowired
    IpfsProperties props;


    public IpfsResp addIpfs(MultipartFile file) {
        String requestUri = "/add";
        IpfsResp info;
        try {
            String fileName = file.getOriginalFilename();
            byte[] fileBytes = file.getBytes();
            URI uri = new URI(props.getScheme(), null, props.getHost(), props.getPort(), props.getPath(), null, null);

            uri = UriComponentsBuilder.fromUri(uri).path(requestUri).build(true).toUri();
            logger.info("API request {}", uri.toString());

            ContentDisposition dispos = ContentDisposition.builder("form-data").name("file").filename(fileName).build();

            MultiValueMap<String, String> fileDescription = new LinkedMultiValueMap<>();
            fileDescription.add(HttpHeaders.CONTENT_DISPOSITION, dispos.toString());
            HttpEntity<byte[]> fileEntity = new HttpEntity<>(fileBytes, fileDescription);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", fileEntity);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<?> httpEntity = new HttpEntity<>(body, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<byte[]> resp = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, byte[].class);
            logger.info("Exchange result {}", new String(resp.getBody()));
            info = JsonUtil.from(resp.getBody(), IpfsResp.class);
        } catch (HttpStatusCodeException e){
            info = JsonUtil.from(e.getResponseBodyAsByteArray(), IpfsResp.class);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return info;
    }

    public IpfsResp addIpfs(BufferedImage bufferedImage, String fileName) {
        String requestUri = "/add";
        IpfsResp info;
        try {
            int pos = fileName.lastIndexOf(".");
            if (pos == -1) {
                throw new IOException("No extension for file: " + fileName);
            }
            String suffix = fileName.substring(pos + 1);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufferedImage, suffix, baos);
            byte[] fileBytes = baos.toByteArray();

            URI uri = new URI(props.getScheme(), null, props.getHost(), props.getPort(), props.getPath(), null, null);

            uri = UriComponentsBuilder.fromUri(uri).path(requestUri).build(true).toUri();
            logger.info("API request {}", uri.toString());

            ContentDisposition dispos = ContentDisposition.builder("form-data").name("file").filename(fileName).build();

            MultiValueMap<String, String> fileDescription = new LinkedMultiValueMap<>();
            fileDescription.add(HttpHeaders.CONTENT_DISPOSITION, dispos.toString());
            HttpEntity<byte[]> fileEntity = new HttpEntity<>(fileBytes, fileDescription);

            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();
            body.add("file", fileEntity);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            HttpEntity<?> httpEntity = new HttpEntity<>(body, headers);
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<byte[]> resp = restTemplate.exchange(uri, HttpMethod.POST, httpEntity, byte[].class);
            logger.info("Exchange result {}", new String(resp.getBody()));
            info = JsonUtil.from(resp.getBody(), IpfsResp.class);
        } catch (HttpStatusCodeException e){
            info = JsonUtil.from(e.getResponseBodyAsByteArray(), IpfsResp.class);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return info;
    }

    public String saveLocalStorage(MultipartFile multipartFile, String folderName) {
        return null;
    }
}
