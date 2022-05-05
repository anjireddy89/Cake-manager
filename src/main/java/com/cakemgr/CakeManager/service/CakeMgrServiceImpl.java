package com.cakemgr.CakeManager.service;

import java.util.List;
import java.util.Optional;

import com.cakemgr.CakeManager.model.CakeEntity;
import com.cakemgr.CakeManager.repository.CakeMgrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CakeMgrServiceImpl implements CakeMgrService {

	@Autowired
	CakeMgrRepository cakeMgrRepository;

	@Override
	public List<CakeEntity> findAllCake() {
		// TODO Auto-generated method stub
		return (List<CakeEntity>) cakeMgrRepository.findAll();
	}

	@Override
	public CakeEntity findById(long id) {
		// TODO Auto-generated method stub
		Optional<CakeEntity> result = cakeMgrRepository.findById(id);
		if (result.isPresent()) {
			return result.get();
		} else {
			return null;
		}
	}

	@Override
	public List<CakeEntity> findByIds(List<Long> id) {
		// TODO Auto-generated method stub
		return (List<CakeEntity>) cakeMgrRepository.findAllById(id);
	}

	@Override
	public CakeEntity insert(CakeEntity cake) {
		// TODO Auto-generated method stub
		return cakeMgrRepository.save(cake);
	}

	@Override
	public List<CakeEntity> insertAll(List<CakeEntity> cake) {
		// TODO Auto-generated method stub
		return (List<CakeEntity>) cakeMgrRepository.saveAll(cake);
	}
}
