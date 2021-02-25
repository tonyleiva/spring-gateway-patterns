package com.tony.link.repository;

import com.tony.link.entity.LinksEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LinksRepository extends JpaRepository<LinksEntity, Integer> {
	List<LinksEntity> findByUserId(Integer userId);
}
