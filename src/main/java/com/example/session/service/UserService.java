package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
//로그인 처리
@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    public void login(LoginRequest loginRequest, HttpSession httpSession){

        var id = loginRequest.getId();
        var password = loginRequest.getPassword();

        //사용자 찾기
        var optionalUser = userRepository.findByName(id);

        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(password)){
                //세션에 userDto 저장
                httpSession.setAttribute("USER", userDto);
            }else{
                throw new RuntimeException("Wrong Password");
            }

        }else{
            throw new RuntimeException("User not Found");
        }

    }
}
