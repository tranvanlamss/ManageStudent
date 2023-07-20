package com.javatechie.util;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class ValidateUtil {

    public static boolean isEmpty(String input){
        if(input == null || input.trim().isEmpty()){
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(String input){
        if(input != null && !(input.trim().isEmpty())){
            return true;
        }
        return false;
    }
    public static boolean isEmpty(MultipartFile file){

        if( file == null || file.isEmpty() || file.getSize() == 0){

            return true;
        }
        return false;
    }
    public static boolean isEmpty(List<?> list) {
        return list == null || list.isEmpty();
    }
}
