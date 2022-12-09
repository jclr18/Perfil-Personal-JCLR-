package com.example.microservice.model;

//lombok es nuestro creador de codigo funcionara con las sgtes anotaciones
import lombok.*;
import org.springframework.hateoas.RepresentationModel;

//anotaciones propias de lombok
@Data
@ToString
@NoArgsConstructor
@RequiredArgsConstructor
public class UserDTO extends RepresentationModel<UserDTO> {

    @NonNull
    private Integer id;

    @NonNull
    private String name;

    @ToString.Exclude
    private String lastname;

}

