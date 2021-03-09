package com.helpnow.funfactory.gamingcardsystem.api;

import com.helpnow.funfactory.gamingcardsystem.exceptions.NoUserExist;
import com.helpnow.funfactory.gamingcardsystem.exceptions.UserAlreadyException;
import com.helpnow.funfactory.gamingcardsystem.model.UserAttributes;
import com.helpnow.funfactory.gamingcardsystem.model.UserInfo;
import com.helpnow.funfactory.gamingcardsystem.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/user")
public class UserController {

    @GetMapping("/fetchUsers")
    public Map<String, UserInfo> fetchUser() throws NoUserExist {
        return UserService.users;
    }


    @GetMapping("/userDetails")
    public UserInfo fetchUser(String userName) throws NoUserExist {
        if (UserService.users.isEmpty())
            throw new NoUserExist();
        UserInfo userInfo = UserService.users.get(userName);
        if(userInfo == null){
            throw new NoUserExist();
        }
        return userInfo;
    }

    @PostMapping("/addUser")
    public UserInfo addUser(@RequestBody UserAttributes user) throws UserAlreadyException {
        if (UserService.users.containsKey(user.getuserName()))
            throw new UserAlreadyException();
        return UserService.addUser(user);
    }

}
