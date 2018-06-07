import {Component, OnInit} from '@angular/core';
import {Recipe} from "../../../shared/structures/recipe";
import {RecipesService} from "../../../shared/services/recipes.service";
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {RecipeCreateComponent} from "../recipe-create/recipe-create.component";
import {map} from "rxjs/internal/operators";

@Component({
  selector: 'wowcraft-recipe-list',
  templateUrl: './recipe-list.component.html',
  styleUrls: ['./recipe-list.component.css']
})
export class RecipeListComponent implements OnInit {
  recipes: Recipe[];

  constructor(private recipeService: RecipesService,
              private modalService: NgbModal) {
  }

  ngOnInit() {
    this.loadRecipes();
  }

  private loadRecipes() {
    this.recipeService.findAll().subscribe(allRecipes => this.recipes = allRecipes);
  }

  craftPrice(recipe: Recipe): number {
    return recipe.reagents
      .map(recipeReagent => recipeReagent.price * recipeReagent.count)
      .reduce((prev, curr) => prev + curr, 0);
  }

  openDialog() {
    this.modalService.open(RecipeCreateComponent).result.then(() => this.loadRecipes(),
      () => this.loadRecipes());
  }
}
