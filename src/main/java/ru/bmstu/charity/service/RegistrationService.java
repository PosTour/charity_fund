package ru.bmstu.charity.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bmstu.charity.domain.Client;
import ru.bmstu.charity.domain.Employee;
import ru.bmstu.charity.domain.User;
import ru.bmstu.charity.dto.ClientRegistrationDto;
import ru.bmstu.charity.dto.EmployeeRegistrationDto;

@Service
@RequiredArgsConstructor
@Transactional
public class RegistrationService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public void registerNewClient(ClientRegistrationDto registrationDto) {
        if (userService.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        var client = new Client(
                registrationDto.getUsername(),
                passwordEncoder.encode(registrationDto.getPassword()),
                User.Role.CLIENT,
                registrationDto.getName(),
                registrationDto.getAddress(),
                registrationDto.getPhone(),
                registrationDto.getEmail());

        userService.save(client);
    }

    public void registerNewEmployee(EmployeeRegistrationDto registrationDto) {
        if (userService.findByUsername(registrationDto.getUsername()).isPresent()) {
            throw new RuntimeException("Пользователь с таким именем уже существует");
        }

        var employee = new Employee(
                registrationDto.getUsername(),
                passwordEncoder.encode(registrationDto.getPassword()),
                User.Role.EMPLOYEE,
                registrationDto.getName(),
                registrationDto.getPosition());

        userService.save(employee);
    }
}
