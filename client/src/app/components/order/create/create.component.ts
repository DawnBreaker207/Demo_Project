import { Component, OnInit } from '@angular/core';
import { OrderService } from '../../../data/services/order.service';
import { ProductService } from '../../../data/services/product.service';
import { Product } from '../../../data/types/product';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrl: './create.component.scss'
})
export class CreateOrderComponent  implements OnInit{
  productData!: Product[]
  createFrom: FormGroup;
  constructor(private orderService: OrderService, private productService: ProductService, private fb: FormBuilder, private route: Router) {
  this.createFrom = this.fb.group({
    customerId: [],
    shipmentMethod: [],
    item: [[]],
    total: []
  })
  }

  ngOnInit(): void {
    this.productService.getAll().subscribe((data)=>{
      this.productData = data;
    })

    this.createFrom.get('item')?.valueChanges.subscribe((selectId: any[]) =>{

      const total = (selectId || []).reduce((sum, item) =>
      {
      return  sum + (item.price * item.quantity)
      }
      , 0
      );
      this.createFrom.get('total')?.setValue(total);
    })
  }

  onSubmit(){
    this.orderService.create(this.createFrom.value).subscribe((data)=>{
      if(data){
        this.route.navigateByUrl("/order");
      }
    })

  }
}
