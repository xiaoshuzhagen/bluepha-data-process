package com.bluepha.common.utils;


import java.util.UUID;

public class UUIDUtils {

    public static String uuid(){
        return UUID.randomUUID().toString().toUpperCase();
    }

    public static void main(String[] args) {
        System.out.println(uuid());
    }

    private UUIDUtils(){}

}
