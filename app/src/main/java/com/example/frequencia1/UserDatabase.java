package com.example.frequencia1;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {
    private static List<User> users;

    static {
        users = new ArrayList<>();
    }

    public static boolean addUser(User user) {
        // Check if the username is already taken
        for (User existingUser : users) {
            if (existingUser.getUsername().equals(user.getUsername())) {
                return false; // Username is already taken
            }
        }

        users.add(user);
        return true; // User added successfully
    }

    public static User getUserByUsername(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static boolean isValidCredentials(String username, String password) {
        User user = getUserByUsername(username);
        return user != null && user.getPassword().equals(password);
    }
}
