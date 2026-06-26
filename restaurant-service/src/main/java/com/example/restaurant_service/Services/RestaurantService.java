package com.example.restaurant_service.Services;

import com.example.restaurant_service.Config.RestClientConfig;
import com.example.restaurant_service.DTO.MenuDTO;
import com.example.restaurant_service.DTO.RestaurantDTO;
import com.example.restaurant_service.Entity.Restaurant;
import com.example.restaurant_service.Repository.RestaurantRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestClient restClient;

    public RestaurantService(RestaurantRepository restaurantRepository, RestClient restClient) {
        this.restaurantRepository = restaurantRepository;
        this.restClient = restClient;
    }

    public Restaurant addRestaurant(RestaurantDTO restaurantDTO){
       Restaurant restaurant=new Restaurant();
       restaurant.setName(restaurantDTO.getName());
       restaurant.setCuisineType(restaurantDTO.getCuisineType());
       restaurant.setPhoneNumber(restaurantDTO.getPhoneNumber());

        List<MenuDTO> menuDTOS=restaurantDTO.getMenuList();
        for(MenuDTO menuDTO:menuDTOS){
          restClient.post()
                  .uri("http://localhost:8080/menu/{restaurantName}",restaurantDTO.getName())
                  .body(menuDTO)
                  .retrieve()
                  .toBodilessEntity();
        }
        return restaurantRepository.save(restaurant);
    }


}
