package com.min0.corona.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Corona {

    private String combinedKey;

    private Double active;

    private Double recovered;

    private Long confirmed;

    private LocalDateTime lastUpdate;

}
