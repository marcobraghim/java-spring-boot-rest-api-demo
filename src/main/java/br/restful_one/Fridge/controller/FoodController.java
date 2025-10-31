package br.restful_one.Fridge.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.restful_one.Fridge.model.FoodModel;
import br.restful_one.Fridge.service.FoodService;
import jakarta.servlet.http.HttpServletResponse;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/food")
public class FoodController {
  
  private final FoodService foodService;

  public FoodController(FoodService foodService) {
    this.foodService = foodService;
  }

  @GetMapping
  public List<FoodModel> getAll() {
    return foodService.getAll();
  }

  @GetMapping("/{id}")
  public FoodModel getMethodName(
    @NonNull @PathVariable Long id,
    HttpServletResponse response
  ) {
    
    var found = foodService.getById(id);
    if (found == null) {
      response.setStatus(HttpStatus.NO_CONTENT.value());
      return null;
    }

    return found;
  }
  

  @PostMapping
  public FoodModel create(@NonNull @RequestBody FoodModel food) {
    return foodService.save(food);
  }

  @DeleteMapping("/{id}")
  public void delete(@NonNull @PathVariable Long id) {
    foodService.deleteById(id);
  }
  
  
}
