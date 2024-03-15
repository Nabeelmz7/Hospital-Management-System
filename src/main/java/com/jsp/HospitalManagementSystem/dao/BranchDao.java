package com.jsp.HospitalManagementSystem.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.HospitalManagementSystem.Repo.BranchRepo;
import com.jsp.HospitalManagementSystem.dto.Address;
import com.jsp.HospitalManagementSystem.dto.Branch;
import com.jsp.HospitalManagementSystem.dto.Hospital;

@Repository
public class BranchDao {
	@Autowired
	private BranchRepo branchRepo;	
	@Autowired
	private HospitalDao hospitalDao;
	@Autowired
	private AddressDao addressDao;
	
	public Branch saveBranch(int hid, int aid, Branch branch) {
		Hospital hospital=hospitalDao.getHospitalById(hid);
		branch.setHospital(hospital);
		Address address=addressDao.getAddressById(aid);
		branch.setAddress(address);
		return branchRepo.save(branch);
	}
	
	public Branch updateBranch(int bid, Branch branch) {
		Branch dbBranch=branchRepo.findById(bid).get();
		if (dbBranch!=null) {
			branch.setId(bid);
			branch.setHospital(dbBranch.getHospital());
			branch.setAddress(dbBranch.getAddress());
			return branchRepo.save(branch);
		}else {
			return null;
		}
	}
	
	public Branch deleteBranch(int bid) {
		if (branchRepo.findById(bid).isPresent()) {
			Branch branch=branchRepo.findById(bid).get();
			branchRepo.deleteById(bid);
			return branch;
		}else {
			return null;
		}
	}
	
	public Branch getBranchById(int bid) {
		if (branchRepo.findById(bid).isPresent()) {
			return branchRepo.findById(bid).get();
		}else {
			return null;
		}
	}
	
	public List<Branch> getBranchByHospitalId(int Hid){
		Hospital hospital=hospitalDao.getHospitalById(Hid);
		return branchRepo.findBranchByHospitalId(hospital);	
	}
}
