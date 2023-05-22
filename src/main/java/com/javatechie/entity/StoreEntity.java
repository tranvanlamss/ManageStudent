package com.javatechie.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

@Table(name = "store")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StoreEntity {
    @Id
    @GeneratedValue(generator = "objectid-generator")
    @GenericGenerator(name = "objectid-generator", strategy = "com.javatechie.common.ObjectIDGenerator")
    @Column(unique=true, nullable=false, length=24)
    private String id;

    @Column(name = "name_store")
    private String nameStore;

    @Column(name = "owner_name")
    String ownerName;
}
