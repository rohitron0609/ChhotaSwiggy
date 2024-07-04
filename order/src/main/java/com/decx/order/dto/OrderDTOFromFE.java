package com.decx.order.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTOFromFE {

    List<FoodItemDTO> foodItemsList;
    private Integer userId;
    private Restaurant restaurant;


}
