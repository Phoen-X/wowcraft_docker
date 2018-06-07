import {RecipeReagent} from "./recipe-reagent";

export class Recipe {
  id: number;
  name: string;
  reagents: RecipeReagent[];


  constructor(id: number = null,
              name: string = null,
              reagents: RecipeReagent[] = []) {
    this.id = id;
    this.name = name;
    this.reagents = reagents;
  }
}
