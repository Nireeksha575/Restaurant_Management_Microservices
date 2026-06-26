package com.example.restaurant_service.Controller;

import com.example.restaurant_service.DTO.RestaurantDTO;
import com.example.restaurant_service.Entity.Restaurant;
import com.example.restaurant_service.Services.RestaurantService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public Restaurant addRestaurant(@RequestBody RestaurantDTO restaurantDTO){
       return restaurantService.addRestaurant(restaurantDTO);
    }
}
