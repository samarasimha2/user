package com.akhm.bo.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akhm.bo.UserBO;
import com.akhm.bo.vo.UserVO;
import com.akhm.exception.MyCustomUserException;
import com.akhm.repository.UserRepository;
import com.akhm.repository.entity.UserEntity;
@Service
public class UserBOImpl implements UserBO{
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserVO getUser(String emailId, String password) {
		try {
			UserEntity user=userRepository.findByEmailIdAndPassword(emailId, password);
			if(user!=null)
			{
				UserVO userVO=new UserVO();
				userVO.setFirstName(user.getFirstName());
				userVO.setLastName(user.getLastName());
				userVO.setEmailId(user.getEmailId());
				userVO.setPassword(user.getPassword());
				userVO.setMobileNumber(user.getMobileNumber());
				
				return userVO;
			}
			else {
				return null;
			}
					
		} catch (Exception e) {
			throw new MyCustomUserException(e.getMessage());
		}
		
	}

	@Override
	public boolean isUserExist(String emailId) {
		boolean isExist=false;
		try {
			UserEntity userEntity=userRepository.findByEmailId(emailId);
			 
			if(userEntity!=null)
			{
				isExist=true;
			}
			
		} catch (Exception e) {
			throw new MyCustomUserException(e.getMessage());
		}
		return isExist;
	}

	@Override
	public Integer insertUser(UserVO userVO) {
		try {
			if(userVO!=null)
			{
				
				UserEntity userEntity=new UserEntity();
				userEntity.setFirstName(userVO.getFirstName());
				userEntity.setLastName(userVO.getLastName());
				userEntity.setEmailId(userVO.getEmailId());
				userEntity.setPassword(userVO.getPassword());
				userEntity.setMobileNumber(userVO.getMobileNumber());
				UserEntity user=userRepository.save(userEntity);
				
				if(user!=null)
				{
					Integer userId = user.getUserId();
				}
						
			}
			else {
				return null;
			}
			
			
			
		} catch (Exception e) {
			throw new MyCustomUserException(e.getMessage());
		}
		return null;
		
	}

}
