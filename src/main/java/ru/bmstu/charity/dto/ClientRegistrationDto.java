package ru.bmstu.charity.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ClientRegistrationDto {

    @NotEmpty(message = "Поле логина должно быть заполнено")
    @Size(min = 2, max = 100, message = "Логин содержать от 5 до 100 символов")
    private String username;

    @NotEmpty
    @NotNull
    private String password;

    private String role;

    @Pattern(regexp = "^[А-ЯЁ][a-яё]+ [А-ЯЁ][a-яё]+ [А-ЯЁ][a-яё]+$",
            message = "Полное имя имеет следующий вид: 'Фамилия Имя Отчество'")
    private String name;

    @NotEmpty
    @NotNull
    private String address;

    @Pattern(regexp = "^\\d{11}$",
            message = "Телефон записывается начинается с цифры 8 и содержит 11 символов")
    private String phone;

    @Email(message = "Некорректный адрес электронной почты")
    private String email;
}
