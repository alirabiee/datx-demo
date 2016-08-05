package com.alirabiee.datx.util;

/**
 * Created by A on 2016-08-05.
 */
public class Null {
    public static < T > T opt(T value, T _default) {
        return value == null ? _default : value;
    }
}
