import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Order } from '../types/order';
import { clearParam } from '../../core/utils/clear-param';

@Injectable({
  providedIn: 'root'
})
export class OrderService {


    BASE_URL: String;
       constructor(private http: HttpClient) {
         this.BASE_URL = `${environment.BASE_URL}/order` ;
       }

        getAll(params?: { [key:string] :any}) {
          const cleanedParams = clearParam(params || {});
          const httpParams = new HttpParams({fromObject: cleanedParams})
          return this.http.get<Order[]>(`${this.BASE_URL}`, {params: httpParams});
         }

         getOne(id: string) {
           return this.http.get<Order>(`${this.BASE_URL}/${id}`);
         }

         create(order: Order) {
           return this.http.post<Order>(`${this.BASE_URL}`, order);
         }

         update(order: Order) {
           return this.http.put<Order>(
             `${this.BASE_URL}/${order.orderId}`,
             order
           );
         }

         delete(id: number) {
           return this.http.delete(`${this.BASE_URL}/${id}`);
         }
}
