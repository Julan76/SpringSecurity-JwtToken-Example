package com.example.demo.els.Impl;

import com.example.demo.domain.els.UserEls;
import com.example.demo.els.repository.UserElsRepository;
import com.example.demo.els.service.UserElsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserElsImpl implements UserElsService {
    private UserElsRepository userElsRepository;

    @Autowired
    public void setUserElsRepository(UserElsRepository userElsRepository) {
        this.userElsRepository = userElsRepository;
    }


    public UserEls save(UserEls userEls) {
      return  userElsRepository.save(userEls);
    }
}
