package com.javatechie.repository;

import org.bson.types.ObjectId;

public class IdUtil {

    public static String generate()  {
        ObjectId id = new ObjectId();
        String sid = id.toHexString();
        //logger.info("Generate an ID: " + sid);
        return sid;
    }
}
