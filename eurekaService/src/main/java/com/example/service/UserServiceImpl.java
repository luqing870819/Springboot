package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.Bean.User;

@Service
public class UserServiceImpl implements UserService{

//	@Autowired
//	private UserMapper userMapper;

	@Override
	public List<User> findAllUser() {
//		return userMapper.findall();
		return null;
	}

}
