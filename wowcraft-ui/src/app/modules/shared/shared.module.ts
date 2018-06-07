import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {ReagentsService} from "./services/reagents.service";
import {HttpClientModule} from "@angular/common/http";
import {BrowserModule} from "@angular/platform-browser";
import {FormsModule} from "@angular/forms";

@NgModule({
  imports: [
    BrowserModule,
    CommonModule,
    FormsModule,
    HttpClientModule,
  ],
  declarations: [],
  providers: [ReagentsService],
  exports: [CommonModule]
})
export class SharedModule {
}
