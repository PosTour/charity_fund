package ru.bmstu.charity.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "fund")
@NoArgsConstructor
@Getter
@Setter
public class Fund {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    @NotNull
    @NotEmpty
    private String name;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "address")
    @NotNull
    @NotEmpty
    private String address;

    public Fund(String name, String email, String address) {
        this.name = name;
        this.email = email;
        this.address = address;
    }
}
