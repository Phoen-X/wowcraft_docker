import {Component, Input, OnInit} from '@angular/core';
import {Reagent} from "../../shared/structures/reagent";
import {ReagentsService} from "../../shared/services/reagents.service";

@Component({
  selector: 'wowcraft-reagent-price',
  templateUrl: './reagent-price.component.html',
  styleUrls: ['./reagent-price.component.css']
})
export class ReagentPriceComponent implements OnInit {

  @Input() reagent: Reagent;
  isUpdating: boolean = false;
  price: number;

  constructor(private reagentService: ReagentsService) {
  }

  ngOnInit() {
    this.price = this.reagent.price;
  }

  updatePrice() {
    this.reagentService.updatePrice(this.reagent, this.price)
      .subscribe(() => this.isUpdating = false);
  }

  startEditing() {
    this.isUpdating = true;
  }
}
