package com.example.securitymaster.ds;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "code cannot be blank.")
    @Size(min = 2, max = 5, message = "code must be between 2 and 5.")
    @Pattern(regexp = "[A-Za-z]*", message = "Code cannot contain illegal characters.")
    private String code;
    @NotBlank(message = "First name cannot be blank")
    @Pattern(regexp = "[A-Za-z-]*", message = "FirstName cannot contain illegal characters.")
    private String firstName;
    @NotBlank(message = "Last name cannot be blank")
    @Pattern(regexp = "[A-Za-z-]*", message = "lastName cannot contain illegal characters.")
    private String lastName;
    @NotBlank(message = "address cannot be blank")
    @Pattern(regexp = "[\\w .\\-/,]*",message = "Address cannot contain illegal characters.")
    private String address;

}
