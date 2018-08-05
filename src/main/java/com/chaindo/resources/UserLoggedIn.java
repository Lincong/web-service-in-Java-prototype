package com.chaindo.resources;

import java.util.HashSet;
import java.util.Set;

public class UserLoggedIn {

    static Set<String> authenticatedUser = new HashSet<>();

    static boolean userLoggedIn(String username) {
        if (username == null) {
            return false;
        }
        return authenticatedUser.contains(username);
    }

    static void logInUser(String username) {
        if (username != null) {
            authenticatedUser.add(username);
        }
    }
}
