package br.restful_one.Fridge.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.restful_one.Fridge.model.FoodModel;

public interface FoodRepository extends JpaRepository<FoodModel, Long> {
  
}
