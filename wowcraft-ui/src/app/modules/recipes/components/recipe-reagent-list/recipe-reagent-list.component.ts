import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {Reagent} from "../../../shared/structures/reagent";
import {ReagentsService} from "../../../shared/services/reagents.service";
import {Observable} from "rxjs/index";
import {distinctUntilChanged, map} from "rxjs/internal/operators";
import {NgbTypeaheadSelectItemEvent} from "@ng-bootstrap/ng-bootstrap";

@Component({
  selector: 'wowcraft-recipe-reagent-list',
  templateUrl: './recipe-reagent-list.component.html',
  styleUrls: ['./recipe-reagent-list.component.css']
})
export class RecipeReagentListComponent implements OnInit {
  availableReagents: Reagent[];
  addingReagent: AddedReagent = new AddedReagent();
  reagents : AddedReagent[] = [];
  @Output() reagentsChanged = new EventEmitter<AddedReagent[]>();

  resultFormatter = (reagent: { name: string }) => {
    return reagent.name;
  };

  searchReagent = (text$: Observable<string>) =>
    text$.pipe(
      distinctUntilChanged(),
      map(term => term === '' || this.availableReagents == null || this.availableReagents.length == 0 ? []
        : this.availableReagents.filter(v => v.name.toLowerCase().indexOf(term.toLowerCase()) > -1)
          .slice(0, 10)),
    );

  reagentSelected = (event : NgbTypeaheadSelectItemEvent) => {
    this.addingReagent.reagent = event.item;
  };


  constructor(private reagentService: ReagentsService) {
  }

  ngOnInit() {
    this.reagentService.getAllReagents().subscribe(reagents => this.availableReagents = reagents);
  }

  addNewReagent() {
    this.reagents.push(Object.assign({}, this.addingReagent));
    this.addingReagent = new AddedReagent();
    this.reagentsChanged.emit(this.reagents);
  }
}

export class AddedReagent{
  reagent : Reagent;
  count : number;

  get reagentName() : string {
    return this.reagent ? this.reagent.name : null;
  }
}
