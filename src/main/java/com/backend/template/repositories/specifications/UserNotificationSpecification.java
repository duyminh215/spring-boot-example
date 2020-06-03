package com.backend.template.repositories.specifications;

import com.backend.template.model.UserNotification;
import org.springframework.data.jpa.domain.Specification;

public class UserNotificationSpecification {

    private UserNotificationSpecification() {
    }

    public static Specification<UserNotification> equality(String field, long key) {
        return (root, query, cb) -> cb.equal(root.get(field), key);
    }
}
