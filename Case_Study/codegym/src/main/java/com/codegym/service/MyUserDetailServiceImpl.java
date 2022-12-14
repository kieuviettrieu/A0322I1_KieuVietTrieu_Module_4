package com.codegym.service;

import com.codegym.model.MyUserDetail;
import com.codegym.model.User;
import com.codegym.repository.util.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MyUserDetailServiceImpl implements UserDetailsService {
    @Autowired
    IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findUserByUserName(username);
        if(user==null)
        {
            throw new UsernameNotFoundException("User name "+username+" not found");
        }
        return new MyUserDetail(user);
    }
}
