package com.hexagonal.domain.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class User {

    private String id;
    private String name;
    private byte age;
    private String country;
    private List<Task> tasks;

}
