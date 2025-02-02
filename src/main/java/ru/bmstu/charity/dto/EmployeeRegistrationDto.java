package ru.bmstu.charity.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class EmployeeRegistrationDto {

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
    private String position;
}
