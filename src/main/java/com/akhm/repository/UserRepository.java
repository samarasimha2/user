package com.akhm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.akhm.repository.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer>{
	public UserEntity findByEmailIdAndPassword(String emailId,String password);
	public UserEntity findByEmailId(String emailId);

}
