package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "object_media")
public class ObjectMedia implements Serializable {
    static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(generator = "objectid-generator")
    @GenericGenerator(name = "objectid-generator", strategy = "com.javatechie.common.ObjectIDGenerator")
    @Column(unique = true, nullable = false, length = 24)
    private String id;
    @Column(nullable = false,name="object_id")
    private String objectId;
    @Column(name="object_type",nullable=false)
    private String objectType;
    @Column(name="ref_value")
    private String refValue;
    @Column(name="ref_type",nullable = false)
    private String refType;
    @Column(name="media_id",nullable = false)
    private String mediaId;

}
