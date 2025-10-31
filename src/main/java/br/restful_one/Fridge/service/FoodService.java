package br.restful_one.Fridge.service;

import java.util.List;

import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import br.restful_one.Fridge.model.FoodModel;
import br.restful_one.Fridge.repository.FoodRepository;

@Service
public class FoodService {
  private final FoodRepository foodRepository;

  public FoodService(FoodRepository foodRepository) {
    this.foodRepository = foodRepository;
  }

  public List<FoodModel> getAll() {
    return foodRepository.findAll();
  }

  public FoodModel getById(@NonNull Long id) {
    return foodRepository.findById(id).orElse(null);
  }

  public FoodModel save(@NonNull FoodModel food) {
    return foodRepository.save(food);
  }

  public void deleteById(@NonNull Long id) {
    foodRepository.deleteById(id);
  }
}
