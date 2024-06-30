package com.decx.restaurantlisting.service;

import com.decx.restaurantlisting.dto.RestaurantDTO;
import com.decx.restaurantlisting.entity.Restaurant;
import com.decx.restaurantlisting.mapper.RestaurantMapper;
import com.decx.restaurantlisting.repository.RestaurentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurentRepository restaurentRepository;

    public List<RestaurantDTO> findAllRestaurant() {
        List<Restaurant> restaurants = restaurentRepository.findAll();
        List<RestaurantDTO> restaurantDTOList = restaurants.stream().map(restaurant -> RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurant)).collect(Collectors.toList());
        return  restaurantDTOList;
    }

    public RestaurantDTO addRestaurant(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant = restaurentRepository.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));
        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);
    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(Integer id) {
        Optional<Restaurant> restaurantOfId = restaurentRepository.findById(id);
        if(restaurantOfId.isPresent()){
            return new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(restaurantOfId.get()), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
