package com.example.session.db;

import com.example.session.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findByName(String name){
        return userList
                .stream()
                .filter( it->{
                return it.getName().equals(name);
        }).findFirst();
    }

    @PostConstruct // 빈 초기화시 해당 메서드 호출.
    public void init(){
        userList.add(
                new UserDto("userNAME")
        );
        userList.add(
                new UserDto("person")
        );
        userList.add(
                new UserDto("sdff")
        );
    }
}
