/*
 * Copyright (c) AppDynamics, Inc., and its affiliates
 * [2015]
 * All Rights Reserved
 */
package com.singularity.ee.agent.util;

import java.util.List;

public class StringUtils {
    public static <T> String join(List<T> objects) {
        StringBuilder sb = new StringBuilder();
        if (objects != null) {
            int size = objects.size();
            sb.append('[');
            for (int i = 0; i < size; i++) {
                sb.append(objects.get(i));
                if (i < size - 1)
                    sb.append(", ");
            }
            sb.append(']');
        }

        return sb.toString();
    }
}