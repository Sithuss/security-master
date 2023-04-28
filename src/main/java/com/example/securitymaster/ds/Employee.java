package com.example.securitymaster.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "first name cannot be blank")
    @Pattern(regexp = "[A-Za-z-]*",message = "First name cannot illegal characters.")
    private String firstName;
    @NotBlank(message = "last name cannot be blank")
    @Pattern(regexp = "[A-Za-z-]*",message = "Last name cannot illegal characters.")
    private String lastName;
    @NotBlank(message = "phone number cannot be blank")
    @Pattern(regexp = "[0-9\\-+]*",message = "Phone number cannot illegal characters.")
    private String phoneNumber;
    @NotBlank(message = "address cannot be blank")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address cannot contain illegal characters.")
    private String address;
    @NotBlank(message = "cubicle number cannot be blank")
    @Pattern(regexp = "[A-Za-z0-9\\-]*",message = "Cube no. cannot illegal characters.")
    private String cubicleNo;
}
