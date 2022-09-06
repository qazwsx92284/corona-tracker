package com.min0.corona.pojo;

import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@EnableAutoConfiguration
public class Corona {

    @Id
    @Column(name = "id", updatable=false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    private String combinedKey;

    private Double active;

    private Double recovered;

    private Long confirmed;

    private LocalDateTime lastUpdate;

}
