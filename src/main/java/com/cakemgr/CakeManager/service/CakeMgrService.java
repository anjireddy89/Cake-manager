package com.cakemgr.CakeManager.service;

import com.cakemgr.CakeManager.model.CakeEntity;

import java.util.List;


public interface CakeMgrService {
	List<CakeEntity> findAllCake();

	CakeEntity findById(long id);

	List<CakeEntity> findByIds(List<Long> id);

	CakeEntity insert(CakeEntity p);

	List<CakeEntity> insertAll(List<CakeEntity> p);


}
