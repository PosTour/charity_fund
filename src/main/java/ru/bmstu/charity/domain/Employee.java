package ru.bmstu.charity.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "employee")
@NoArgsConstructor
@Getter
@Setter
public class Employee extends User {

    @Column(name = "full_name")
    @Pattern(regexp = "^[А-ЯЁ][a-яё]+ [А-ЯЁ][a-яё]+ [А-ЯЁ][a-яё]+$",
            message = "Полное имя имеет следующий вид: 'Фамилия Имя Отчество'")
    private String name;

    @Column(name = "phone")
    private String position;
}