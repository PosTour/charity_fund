package ru.bmstu.charity.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "client")
@NoArgsConstructor
@Getter
@Setter
public class Client extends User {

    @Column(name = "full_name")
    @Pattern(regexp = "^[А-ЯЁ][a-яё]+ [А-ЯЁ][a-яё]+ [А-ЯЁ][a-яё]+$",
            message = "Полное имя имеет следующий вид: 'Фамилия Имя Отчество'")
    private String name;

    @NotEmpty
    @NotNull
    @Column(name = "address")
    private String address;

    @Column(name = "phone")
    @Pattern(regexp = "^\\d{11}$",
            message = "Телефон записывается начинается с цифры 8 и содержит 11 символов")
    private String phone;

    @Column(name = "email")
    @Email(message = "Некорректный адрес электронной почты")
    private String email;

    public Client(String username, String password, Role role, String name, String address, String phone, String email) {
        super(username, password, role);
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}
