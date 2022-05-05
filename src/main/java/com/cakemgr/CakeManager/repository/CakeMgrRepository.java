package com.cakemgr.CakeManager.repository;

import com.cakemgr.CakeManager.model.CakeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CakeMgrRepository extends JpaRepository<CakeEntity, Long>{

}
