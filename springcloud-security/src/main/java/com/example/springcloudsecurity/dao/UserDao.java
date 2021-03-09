package com.example.springcloudsecurity.dao;

import com.example.springcloudsecurity.bean.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Long> {

    public User findByUsername(String username);
}
