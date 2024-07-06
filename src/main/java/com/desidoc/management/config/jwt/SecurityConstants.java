package com.desidoc.management.config.jwt;

import java.util.Base64;

public class SecurityConstants {

    public static final long JWT_EXPIRATION = 86400000; // 1 day in milliseconds
    //    public static final long JWT_EXPIRATION = 300000; // 5 minutes in milliseconds
    public static final String JWT_SECRET = Base64.getEncoder().encodeToString("TemporaryLongSecretKey_KSJkj1k2jklJ:i1jk34m2/JKjuj8ou(i2389uKLJ<?:{P+!!@#$j8u2jk,O@JKjn8U".getBytes());
    ;
}
