import {Injectable} from '@angular/core';
import {Observable} from "rxjs/index";
import {Recipe} from "../structures/recipe";
import {HttpClient} from "@angular/common/http";
import {wowcraftApiHost} from "../structures/wowcraft-api-host";

@Injectable({
  providedIn: 'root'
})
export class RecipesService {

  constructor(private http: HttpClient) {
  }


  public findAll(): Observable<Recipe[]> {
    return this.http.get<Recipe[]>(wowcraftApiHost + "/recipes");
  }

  public addNewRecipe(recipe: Recipe) : Observable<any> {
    return this.http.post(wowcraftApiHost + "/recipes", recipe);
  }
}
