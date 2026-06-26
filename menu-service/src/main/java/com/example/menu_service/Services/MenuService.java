package com.example.menu_service.Services;

import com.example.menu_service.DTO.MenuDTO;
import com.example.menu_service.Entity.Menu;
import com.example.menu_service.Repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuService {
    private final MenuRepository menuRepository;

    public MenuService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;
    }

    public void addMenu(MenuDTO menuDTO,String name){
      Menu menu=new Menu();
      menu.setItemName(menuDTO.getItemName());
      menu.setPrice(menuDTO.getPrice());
      menu.setRestaurantName(name);
      menuRepository.save(menu);
    }

    public List<MenuDTO> getMenus(String name) {
      List<Menu> menus= menuRepository.findByRestaurantName(name);
      return menus.stream()
              .map(menu -> toMenuDTO(menu))
              .toList();
    }

    private MenuDTO toMenuDTO(Menu menu){
      MenuDTO menuDTO=new MenuDTO();
      menuDTO.setItemName(menu.getItemName());
      menuDTO.setPrice(menu.getPrice());
      return menuDTO;
    }
}
