package com.javatechie.repository;

import com.javatechie.entity.ObjectMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface ObjectMediaRepository extends JpaRepository<ObjectMedia, String> {

    List<ObjectMedia> findByObjectTypeAndObjectIdAndRefType(String objectType, String objectId, String refType);

    @Query(value = "SELECT * FROM object_media o" +
            " WHERE o.object_type = ?1" +
            " and o.object_id = ?2" +
            " and o.ref_type = ?3 limit 1", nativeQuery = true)
    Optional<ObjectMedia> findAvatarObject(String objectType, String objectId, String refType);

    @Modifying
    @Transactional
    @Query(value="delete o, m " +
            "from object_media as o " +
            "join media as m  ON o.media_id = m.id " +
            "WHERE o.media_id in :listMediaDelete ", nativeQuery = true)
    void deleteObjectMediaAndMediaByMediaIds(@Param("listMediaDelete") List<String> listMediaDelete);
    @Modifying
    @Transactional
    @Query(value="delete o, m " +
            "from object_media as o " +
            "join media as m  ON o.media_id = m.id " +
            "WHERE o.object_id in :objectIds and (:typeImage is null or o.ref_type =:typeImage)", nativeQuery = true)
    void deleteObjectMediaAndMediaByObjectIds(@Param("objectIds")List<String> objectIds,String typeImage);
    @Query(value = "SELECT * FROM object_media o" +
            " WHERE o.object_type = ?1" +
            " and o.object_id in ?2" +
            " and o.ref_type = ?3 ", nativeQuery = true)
    List<ObjectMedia> findAvatarObjects(String objectType, List<String> objectIds, String refType);

    @Query("SELECT u FROM ObjectMedia u" +
            " WHERE u.objectType = 'PRODUCT'" +
            " and u.objectId = ?1" +
            " and u.refType = ?2")
    List<ObjectMedia> findProductImages(String productId, String refType);

    @Query("SELECT u FROM ObjectMedia u" +
            " WHERE u.objectType = 'STORE'" +
            " and u.objectId = ?1" +
            " and u.refType = ?2")
    List<ObjectMedia> findStoreImages(String storeId, String refType);

    @Query("SELECT o FROM ObjectMedia o" +
            " WHERE o.objectId IN ?1 " +
            "and o.objectType ='PRODUCT'" +
            "and o.refType = 'IMAGE_PRODUCT'")
    List<ObjectMedia> findMediaAvatarProductByListId(List<String> list);
}
