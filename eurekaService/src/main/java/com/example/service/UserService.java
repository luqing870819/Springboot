package com.example.service;

import java.util.List;

import com.example.Bean.User;

public interface UserService {
	/**
     * 根据接口查询所用的用户
     */
    public List<User> findAllUser();
}
