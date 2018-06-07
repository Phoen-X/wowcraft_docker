import {Component, OnInit} from '@angular/core';
import {NgbActiveModal} from "@ng-bootstrap/ng-bootstrap";
import {Recipe} from "../../../shared/structures/recipe";
import {AddedReagent} from "../recipe-reagent-list/recipe-reagent-list.component";
import {RecipeReagent} from "../../../shared/structures/recipe-reagent";
import {RecipesService} from "../../../shared/services/recipes.service";

@Component({
  templateUrl: './recipe-create.component.html',
  styleUrls: ['./recipe-create.component.css']
})
export class RecipeCreateComponent implements OnInit {
  recipe: Recipe = new Recipe();


  constructor(public modal: NgbActiveModal,
              private recipeService: RecipesService) {
  }

  ngOnInit() {

  }

  reagentsChanged(newReagents: AddedReagent[]) {
    this.recipe.reagents = newReagents.map(addedReagent => new RecipeReagent(addedReagent.reagent.id,
      addedReagent.reagent.name,
      addedReagent.reagent.price,
      addedReagent.count));
  }

  saveRecipe() {
    this.recipeService.addNewRecipe(this.recipe)
      .subscribe(() => {
        this.recipe = new Recipe();
        this.modal.close('Added');
      });
  }
}
