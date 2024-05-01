package com.example.session.db;

import com.example.session.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
//db대신
public class UserRepository {

    public List<UserDto> userList = new ArrayList<>();

    public Optional<UserDto> findByName(String name){ //필터로 넘어온 이름이 일치한지 확인 후 넘겨줌
        return userList
                .stream()
                .filter( it->{
                return it.getName().equals(name);
        }).findFirst();
    }

    @PostConstruct // 빈 초기화시 해당 메서드 호출.
    public void init(){ //빈 리스트에 생성해줌
        userList.add(
                new UserDto("userNAME" , "1234")
        );
        userList.add(
                new UserDto("person" , "1234")
        );
        userList.add(
                new UserDto("sdff" , "1234")
        );
    }
}
