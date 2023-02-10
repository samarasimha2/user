package com.akhm.bo;

import com.akhm.bo.vo.UserVO;

public interface UserBO {
	public UserVO getUser(String emailId,String password);
	public boolean isUserExist(String emailId);
	public Integer insertUser(UserVO userVO);

}
