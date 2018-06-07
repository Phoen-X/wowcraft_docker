import {Injectable} from '@angular/core';
import {Reagent} from "../structures/reagent";
import {Observable} from 'rxjs';
import {HttpClient} from "@angular/common/http";
import {wowcraftApiHost} from "../structures/wowcraft-api-host";

@Injectable()
export class ReagentsService {
  host: string;

  constructor(private http: HttpClient) {
    this.host = wowcraftApiHost;
  }

  public getAllReagents(): Observable<Reagent[]> {
    return this.http.get<Reagent[]>(this.url("/reagents"));
  }

  public addReagent(reagent: Reagent): Observable<Object> {
    return this.http.post(this.url("/reagents"), reagent);
  }

  public updatePrice(reagent: Reagent, newPrice: number) : Observable<Object> {
    const newReagent = Object.assign({}, reagent, {price: newPrice});
    return this.http.post(this.url("/reagents"), newReagent);
  }

  private url(suffix: string): string {
    return this.host + suffix;
  }
}
