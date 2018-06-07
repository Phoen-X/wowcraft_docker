import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';
import {ReagentsService} from "../../shared/services/reagents.service";
import {Reagent} from "../../shared/structures/reagent";

@Component({
  selector: 'wowcraft-reagent-create',
  templateUrl: './reagent-create.component.html',
  styleUrls: ['./reagent-create.component.css']
})
export class ReagentCreateComponent implements OnInit {
  newReagent : Reagent = new Reagent();
  @Output() submit = new EventEmitter<void>();

  constructor(private reagentService : ReagentsService) { }

  ngOnInit() {
  }

  saveReagent() {
    this.reagentService.addReagent(this.newReagent)
      .subscribe(() => {
        this.newReagent = new Reagent();
        this.submit.emit();
      });

  }
}
