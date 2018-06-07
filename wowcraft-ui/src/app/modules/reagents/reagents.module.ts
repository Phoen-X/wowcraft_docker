import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ReagentsListComponent} from './reagents-list/reagents-list.component';
import {RouterModule} from "@angular/router";
import {ReagentsService} from "../shared/services/reagents.service";
import {SharedModule} from "../shared/shared.module";
import {ReagentPriceComponent} from './reagent-price/reagent-price.component';
import {FormsModule} from "@angular/forms";
import { ReagentCreateComponent } from './reagent-create/reagent-create.component';

@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    SharedModule,
    RouterModule.forChild([
      {path: 'reagents', component: ReagentsListComponent}
    ])
  ],
  declarations: [ReagentsListComponent, ReagentPriceComponent, ReagentCreateComponent],
  providers: [ReagentsService]
})
export class ReagentsModule {
}
