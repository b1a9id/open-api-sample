package com.b1a9idps.openapisample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.b1a9idps.openapisample.entity.Sake;

@Repository
public interface SakeRepository extends JpaRepository<Sake, Integer> {
}
