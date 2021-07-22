package com.codeup.springblog.models;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdRepository extends JpaRepository<Ad, Long> {
    @Query("from Ad a where a.id = ?1")
    Ad findById(long id);

    @Query("from Ad a where a.title like %:term%")
    Ad findByTitle(String term);
}
