import {Component, OnInit} from '@angular/core';
import {Reagent} from "../../shared/structures/reagent";
import {ReagentsService} from "../../shared/services/reagents.service";

@Component({
  templateUrl: './reagents-list.component.html',
})
export class ReagentsListComponent implements OnInit {
  reagents: Reagent[];
  isAdding: boolean = false;

  constructor(private reagentService: ReagentsService) {
  }

  ngOnInit() {
    this.retrieveReagents();
  }

  private retrieveReagents() {
    this.reagentService.getAllReagents().subscribe(reagents => this.reagents = reagents);
  }


  startAddingReagent() {
    this.isAdding = true;
  }

  finishAdding() {
    this.retrieveReagents();
    this.isAdding = false;

  }
}
