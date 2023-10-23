package com.twilio.jdbcTemplate.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Student {

    @JsonProperty("id")
    @Getter @Setter
    private int id;

    @NotBlank
    @JsonProperty("firstName")
    @Getter @Setter
    private String firstName;

    @NotBlank
    @JsonProperty("lastName")
    @Getter @Setter
    private String lastName;

    @NotBlank
    @JsonProperty("email")
    @Getter @Setter
    private String email;
}
