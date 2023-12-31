package com.example.apimovie.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.apimovie.dto.LoginDto;
import com.example.apimovie.entity.Account;
import com.example.apimovie.repo.LoginRepository;
import com.example.apimovie.response.Message;

@Service
public class LoginServiceImp implements LoginService{


    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public String login(Account account) {
        Account temp = loginRepository.findByEmail(account.getEmail());
        if(temp!=null){
            return "Email is already exits";
        }else{
            account.setPassword(passwordEncoder.encode(account.getPassword()));
            System.out.println(account.getPassword());
            loginRepository.save(account);
            return account.getEmail();
        }
    }

    @Override
    public Message loginMessage(LoginDto loginDto) {
        String msg="";
        Account account = loginRepository.findByEmail(loginDto.getEmail());
        if(account != null){
            String password = loginDto.getPassword();
            String encodedPassword = account.getPassword();
            Boolean isPwdRight = passwordEncoder.matches(password,encodedPassword);
            if(isPwdRight){
                Optional<Account>account1=loginRepository.findByEmailAndPassword(loginDto.getEmail(),encodedPassword);
                if(account1.isPresent()){
                    return new Message("Login success",true);
                }else{
                    return new Message("Login failed", false);
                }
            }else{
                return new Message("Password not match", false);
            }
        }else{
            return new Message("Email not exits",false);
        }

    }


}
