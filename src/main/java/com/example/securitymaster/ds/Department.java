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

@Entity
@Getter @Setter
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "code cannot be blank.")
    @Pattern(regexp = "[A-Za-z]*", message = "Code cannot contain illegal characters.")
    private String code;
    @NotBlank(message = "name cannot be blank")
    @Pattern(regexp = "[A-Za-z]*", message = "Name cannot contain illegal characters.")
    private String name;
    @NotBlank(message = "country cannot be blank.")
    @Pattern(regexp = "[A-Za-z]*", message = "Country cannot contain illegal characters.")
    private String country;
}
