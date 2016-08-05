package com.alirabiee.datx.util;

/**
 * Created by A on 2016-08-05.
 */
public class Is {
    public static boolean yes(final Boolean value) {
        return value != null && value;
    }

    public static boolean equal(final Object p, final Object q) {
        return ( p == null && q == null ) || ( p != null && q != null && p.equals( q ) );
    }

    public static boolean unequal(final Object p, final Object q) {
        return !equal( p, q );
    }
}
