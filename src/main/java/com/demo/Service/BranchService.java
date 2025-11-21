package com.demo.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Branch;
import com.demo.repository.BranchDao;

@Service
public class BranchService {
	@Autowired
	BranchDao repo;

	public List<Branch> getBranchesByRegion(String region) {
		if (region == null || region.trim().isEmpty() || region.equals("All")) {
			return repo.findAll();
		}
		return repo.findByRegion(region);
	}

	public List<Branch> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
