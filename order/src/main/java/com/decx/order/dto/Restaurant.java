package com.decx.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {

    private int Id;
    private String name;
    private String Description;
    private String city;
    private String address;

}
