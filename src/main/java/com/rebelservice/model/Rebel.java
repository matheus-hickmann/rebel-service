package com.rebelservice.model;

import com.rebelservice.controller.dto.request.RebelRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rebel {

    @Id
    @Column(name = "id")
    @GenericGenerator(name = "UUIDGenerator", strategy = "uuid2")
    @GeneratedValue(generator = "UUIDGenerator")
    private UUID id;

    private String name;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Location location;

    public static Rebel fromRequest(RebelRequest request) {
        return Rebel.builder()
                .age(request.age())
                .gender(request.gender())
                .location(Location.fromRequest(request.location()))
                .name(request.name())
                .build();
    }

}
