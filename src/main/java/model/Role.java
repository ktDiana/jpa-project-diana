package model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor

public enum Role {
    USER("user", "Пользователь"),
    MODER("moderator", "Модератор"),
    ADMIN("admin", "Администратор");

    private String serviceName;
    private String displayName;

    Role(String serviceName, String displayName) {
        this.serviceName = serviceName;
        this.displayName = displayName;
    }

}
