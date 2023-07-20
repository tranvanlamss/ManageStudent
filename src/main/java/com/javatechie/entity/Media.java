package com.javatechie.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIdentityInfo(generator= ObjectIdGenerators.PropertyGenerator.class, property="id", scope=String.class)
@Table(name = "media")
public class Media {
    @Id
    @Column(unique=true, nullable=false, length=24)
    String id;

    @Column(length=256)
    String hash;

    @Column(nullable=false, length=256)
    String name;

    @Column(nullable=false)
    double size;

    @Column(nullable=false, length=256)
    String type;

    @Column(length=256)
    String path;

    @Column(length=256)
    String storageType;

    @Column(name = "creater_id", length = 24)
    private String createrId;

    @Column(name = "created_time", nullable = false)
    private LocalDateTime createdTime;
}
