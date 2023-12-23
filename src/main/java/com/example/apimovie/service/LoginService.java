package com.example.apimovie.service;

import com.example.apimovie.dto.LoginDto;
import com.example.apimovie.entity.Account;
import com.example.apimovie.response.Message;


public interface LoginService {
    String login(Account account);
    Message loginMessage(LoginDto loginDto);

}
