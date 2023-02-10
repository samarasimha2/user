package com.akhm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.akhm.bo.UserBO;
import com.akhm.bo.vo.UserVO;

@Controller
@RequestMapping("/user/v0")
public class UserController {
	@Autowired
	private UserBO userBO;
	@GetMapping("/isUserExist")
	public ResponseEntity<Boolean> isUserExist(@RequestParam String emailId)
	{
		try {
			Boolean isExists=userBO.isUserExist(emailId);
			return new ResponseEntity<>(isExists,HttpStatus.OK);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
	}
	@PostMapping("/registration")
	public ResponseEntity<Integer> registration(@RequestBody UserVO userVO)
	{
		try {
			Integer userId = userBO.insertUser(userVO);
			return new ResponseEntity(userId, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	@PostMapping("/login")
	public ResponseEntity<UserVO> login(@RequestBody UserVO userVO)
	{
		try {
			UserVO user=userBO.getUser(userVO.getEmailId(), userVO.getPassword());
			return new ResponseEntity(user,HttpStatus.CREATED);
			
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}

}
