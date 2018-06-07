package com.wowcraft.rest.app.repositories;

import com.wowcraft.rest.app.repositories.entities.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
