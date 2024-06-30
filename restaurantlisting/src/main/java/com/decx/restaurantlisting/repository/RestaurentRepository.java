package com.decx.restaurantlisting.repository;

import com.decx.restaurantlisting.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurentRepository extends JpaRepository<Restaurant,Integer> {
}
