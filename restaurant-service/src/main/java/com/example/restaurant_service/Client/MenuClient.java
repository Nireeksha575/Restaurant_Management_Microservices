package com.example.restaurant_service.Client;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@EnableFeignClients
@FeignClient(name = "menu-service")
public interface MenuClient {

}
