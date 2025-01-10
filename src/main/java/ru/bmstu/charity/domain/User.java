package ru.bmstu.charity.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "user_table")
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@Getter
@Setter
public class User {

    public enum Role {
        EMPLOYEE("Employee"),
        CLIENT("Client");

        private final String label;

        Role(String label) {
            this.label = label;
        }

        private static final Map<String, Role> LOOKUP_MAP = new HashMap<>();

        static {
            for (Role type : values()) {
                LOOKUP_MAP.put(type.label, type);
            }
        }

        public static Role getTypeByString(String type) {
            return LOOKUP_MAP.get(type);
        }

        @Override
        public String toString() {
            return label;
        }
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private int id;

    @NotEmpty(message = "Поле логина должно быть заполнено")
    @Size(min = 2, max = 100, message = "Логин содержать от 5 до 100 символов")
    @Column(name = "username")
    private String username;

    @NotEmpty
    @NotNull
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;

    public User(String username, String password, String role) {
        this.username = username;
        this.password = password;
        this.role = Role.getTypeByString(role);
    }
}
