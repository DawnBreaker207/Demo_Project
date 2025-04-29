import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Customer } from '../types/customer';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {

  BASE_URL: String;
   constructor(private http: HttpClient) {
     this.BASE_URL = `${environment.BASE_URL}/customer` ;
   }

     getAll() {
       return this.http.get<Customer[]>(`${this.BASE_URL}`);
     }

     getOne(id: string) {
       return this.http.get<Customer>(`${this.BASE_URL}/${id}`);
     }

     create(customer: Customer) {
       return this.http.post<Customer>(`${this.BASE_URL}`, customer);
     }

     update(customer: Customer) {
       return this.http.put<Customer>(
         `${this.BASE_URL}/${customer.id}`,
         customer
       );
     }

     delete(id: number) {
       return this.http.delete(`${this.BASE_URL}/${id}`);
     }
}
