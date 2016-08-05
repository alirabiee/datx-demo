package com.alirabiee.datx.util;

import java.util.Collection;

/**
 * Created by A on 2016-08-05.
 */
public class Is {
    public static boolean yes(final Object value) {
        return value != null && (
            ( value instanceof Boolean && ( Boolean ) value ) ||
            ( value instanceof String && String.valueOf( value ).equalsIgnoreCase( "true" ) )
        );
    }

    public static boolean validId(final Object id) {
        return id != null && id instanceof Long && ( ( Long ) id ) > 0;
    }

    public static boolean equal(final Object p, final Object q) {
        return ( p == null && q == null ) || ( p != null && q != null && p.equals( q ) );
    }

    public static boolean unequal(final Object p, final Object q) {
        return !equal( p, q );
    }

    public static boolean empty(final Object value) {
        return value == null ||
               ( value instanceof String && String.valueOf( value ).trim().isEmpty() ) ||
               ( value instanceof Collection && ( ( Collection ) value ).isEmpty() )
            ;
    }
}
