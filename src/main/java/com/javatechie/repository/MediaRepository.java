package com.javatechie.repository;


import com.javatechie.entity.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MediaRepository extends JpaRepository<Media, String> {

    Optional<Media> findByHash(String hash);

}
