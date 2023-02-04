import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cabtype } from '../classes/cabtype';

@Injectable({
  providedIn: 'root'
})
export class CabTypesService {

  constructor(private HttpClient:HttpClient) { }

  getTypes(): Observable<Cabtype[]>{
    return this.HttpClient.get<Cabtype[]>('http://localhost:9191/cabtype/findAllCabType');
  }
}
