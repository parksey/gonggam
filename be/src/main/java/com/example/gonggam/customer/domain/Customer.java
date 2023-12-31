package com.example.gonggam.customer.domain;

import com.example.gonggam.util.UtilsCode;
import com.example.gonggam.util.exception.ValidationStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Entity
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long customerId;

    @Email(regexp = UtilsCode.Global.EMAIL_PATTERN, message = ValidationStatus.Global.NOT_EMAIL)
    @NotNull
    @Column(unique = true)
    String email;

    @NotNull
    String password;

    String name;

    @Pattern(regexp = UtilsCode.Global.PHONE_PATTERN, message = ValidationStatus.Global.NOT_PHONE_PATTERN)
    @NotNull
    String phone;

    LocalDateTime createAt;

    private Customer(final Long customerId,
                     final String email,
                     final String password,
                     final String name,
                     final String phone,
                     final LocalDateTime createAt) {
        this.customerId = customerId;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.name = name;
        this.createAt = createAt;
    }

    @Builder
    public Customer(String email,
                    String password,
                    String name,
                    String phone) {
        this(null, email, password, name, phone, LocalDateTime.now());
    }

    protected Customer() {
    }
}
