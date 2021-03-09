package com.helpnow.funfactory.gamingcardsystem.service;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.helpnow.funfactory.gamingcardsystem.config.Constant;
import com.helpnow.funfactory.gamingcardsystem.model.Card;
import com.helpnow.funfactory.gamingcardsystem.exceptions.UserAlreadyException;
import com.helpnow.funfactory.gamingcardsystem.model.UserAttributes;
import com.helpnow.funfactory.gamingcardsystem.model.UserInfo;

public class UserService {
    static int userAdded = 0;
    public static Map<String, UserInfo> users = new HashMap<>();
    private static final ObjectMapper mapper = new ObjectMapper();

    private static final String fileName = "userDetails.json";

    static {
        try (InputStream is = new FileInputStream(fileName)) { //  UserService.class.getClassLoader().getResourceAsStream(
            if (is == null) {
                createFile();
            }
            try (BufferedReader in = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8))) {
                String cache = in.lines().collect(Collectors.joining());
                users = mapper.readValue(cache, Map.class);
            }
        } catch (Exception e) {
            createFile();
        }
    }

    private static void createFile() {
        try {
            writeIntoFile("");
        } catch (Exception e) {
        }
    }


    private static File writeIntoFile(String s) throws FileNotFoundException {
        File file = new File(fileName); // String.valueOf(UserService.class.getClassLoader().getResource(
        PrintWriter writer = new PrintWriter(file.getPath());
        writer.write(s);
        writer.close();
        return file;
    }

    private static void writeCache() {
        try {
            String userDetails = mapper.writeValueAsString(users);
            writeIntoFile(userDetails);
        } catch (Exception e) {

        }
    }

    public static UserInfo addUser(UserAttributes userAttributes) throws UserAlreadyException {
        if (users.containsKey(userAttributes.getuserName())) {
            throw new UserAlreadyException();
        }
        UserInfo user = new UserInfo(userAttributes, new Card(userAttributes.getuserName()));
        users.put(user.getUserBasicDetails().getuserName(), user);
        userAdded++;
        if (userAdded == Constant.LIMIT_USER_WRITE) {
            writeCache();
            userAdded = 0;
        }
        return user;
    }

}
