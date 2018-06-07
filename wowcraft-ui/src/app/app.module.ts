import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {WowcraftRootComponent} from './components/wowcraft-root/wowcraft-root.component';
import {RouterModule} from "@angular/router";
import {ReagentsModule} from "./modules/reagents/reagents.module";
import {WelcomeMessageComponent} from './components/welcome-message/welcome-message.component';
import {RecipesModule} from "./modules/recipes/recipes.module";

@NgModule({
  declarations: [
    WowcraftRootComponent,
    WelcomeMessageComponent,
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot([
      {path: '', pathMatch: 'full', component: WelcomeMessageComponent},
      {path: '**', pathMatch: 'full', redirectTo: ''}
    ]),
    ReagentsModule,
    RecipesModule
  ],
  providers: [],
  bootstrap: [WowcraftRootComponent]
})
export class AppModule {
}
