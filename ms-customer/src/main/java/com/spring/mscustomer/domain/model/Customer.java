package com.spring.mscustomer.domain.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Builder
public class Customer {

    private Long id;
    private String name;
    private String document;
    private String address;
    private String email;
    private String phone;
}
