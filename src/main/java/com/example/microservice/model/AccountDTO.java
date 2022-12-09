package com.example.microservice.model;

//lombok es nuestro creador de codigo funcionara con las sgtes anotaciones

import lombok.Data;
import lombok.NoArgsConstructor;


//anotaciones propias de lombok
@Data
@NoArgsConstructor
public class AccountDTO  {

    private Integer id;

    private String name;
}
