package com.wowcraft.rest.app.endpoints;

import com.wowcraft.rest.app.repositories.entities.Reagent;
import com.wowcraft.rest.app.repositories.ReagentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("reagents")
public class ReagentsController {
    private final ReagentRepo repo;

    @Autowired
    public ReagentsController(ReagentRepo repo) {
        this.repo = repo;
    }

    @GetMapping
    public Iterable<Reagent> findAll() {
        return repo.findAll();
    }

    @PostMapping
    public Reagent add(@RequestBody Reagent reagent) {
        return repo.save(reagent);
    }

    @PutMapping
    public Reagent edit(@RequestBody Reagent reagent) {
        return repo.save(reagent);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repo.deleteById(id);
    }
}
