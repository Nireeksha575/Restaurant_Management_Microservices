package com.example.menu_service.Controller;

import com.example.menu_service.DTO.MenuDTO;
import com.example.menu_service.Services.MenuService;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @PostMapping("/{restaurantName}")
    public void addMenu(@RequestBody MenuDTO menuDTO,@PathVariable String restaurantName){
        menuService.addMenu(menuDTO,restaurantName);
    }

    @GetMapping("/{name}")
    public List<MenuDTO> getMenus(@PathVariable String name){
       return menuService.getMenus(name);
    }
}
