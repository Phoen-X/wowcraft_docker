import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {SharedModule} from "../shared/shared.module";
import {RecipeListComponent} from './components/recipe-list/recipe-list.component';
import {RouterModule} from "@angular/router";
import {RecipeCreateComponent} from './components/recipe-create/recipe-create.component';
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule} from "@angular/forms";
import { RecipeReagentListComponent } from './components/recipe-reagent-list/recipe-reagent-list.component';

@NgModule({
  imports: [
    CommonModule,
    SharedModule,
    FormsModule,
    NgbModule.forRoot(),
    RouterModule.forChild([
      {path: 'recipes', component: RecipeListComponent}
    ])
  ],
  declarations: [RecipeListComponent, RecipeCreateComponent, RecipeReagentListComponent],
  providers: [],
  entryComponents: [RecipeCreateComponent]
})
export class RecipesModule {
}
