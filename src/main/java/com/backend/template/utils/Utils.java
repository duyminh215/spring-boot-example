package com.backend.template.utils;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.domain.Sort.Order;

public class Utils {

    public static List<Order> getOrderFieldsOfRequest(String sortInput) {
        if (sortInput == null || sortInput.trim().isEmpty()) {
            return new LinkedList<Order>();
        }
        String fields[] = sortInput.split(",");
        if (fields == null || fields.length == 0) {
            return new LinkedList<Order>();
        }
        List<Order> sortFields = new LinkedList<Order>();
        for (String field : fields) {
            sortFields.add(detectSortAscOrDesc(field));
        }
        return sortFields;
    }

    public static Order detectSortAscOrDesc(String field) {
        if (field.contains("-")) {
            field = field.replace("-", "");
            return Order.desc(field);
        }
        return Order.asc(field);
    }

    public static long getUnixTimeInSecond() {
        return System.currentTimeMillis() / 1000L;
    }

    public static boolean isStringEmpty(String string) {
        if (string == null || string.trim().isEmpty()) {
            return true;
        }
        return false;
    }
}
