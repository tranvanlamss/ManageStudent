package com.javatechie.util;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;



public final class UserUtil {

    public static String getUserName() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            return authentication.getName();
        }

        return null;
    }
}
