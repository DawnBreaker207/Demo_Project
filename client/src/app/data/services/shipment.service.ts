import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Shipment } from '../types/shipment';

@Injectable({
  providedIn: 'root'
})
export class ShipmentService {
    BASE_URL: String;
     constructor(private http: HttpClient) {
       this.BASE_URL = `${environment.BASE_URL}/shipment` ;
     }

         getAll() {
            return this.http.get<Shipment[]>(`${this.BASE_URL}`);
          }

          getOne(id: string) {
            return this.http.get<Shipment>(`${this.BASE_URL}/${id}`);
          }
        }
