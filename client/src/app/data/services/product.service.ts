import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../../environments/environment.development';
import { Product } from '../types/product';



@Injectable({
  providedIn: 'root',
})
export class ProductService {
  BASE_URL: String;
  constructor(private http: HttpClient) {
    this.BASE_URL = environment.BASE_URL;
  }

  getAll() {
    return this.http.get<Product[]>(`${this.BASE_URL}/products`);
  }

  getOne(id: string) {
    return this.http.get<Product>(`${this.BASE_URL}/product/${id}`);
  }

  create(product: Product) {
    return this.http.post<Product>(`${this.BASE_URL}/product`, product);
  }

  update(product: Product) {
    return this.http.put<Product>(
      `${this.BASE_URL}/product/${product.id}`,
      product
    );
  }

  delete(id: number) {
    return this.http.delete(`${this.BASE_URL}/product/${id}`);
  }
}
