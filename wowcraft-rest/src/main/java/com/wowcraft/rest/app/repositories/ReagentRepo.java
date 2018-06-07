package com.wowcraft.rest.app.repositories;

import com.wowcraft.rest.app.repositories.entities.Reagent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReagentRepo extends CrudRepository<Reagent, Integer> {
}
