import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ProductComponent } from './pages/product/product.component';
import { OrderViewComponent } from './components/order/view/view.component';
import { ShipmentViewComponent } from './components/shipment/view/view.component';
import { CustomerViewComponent } from './components/customer/view/view.component';
import { CreateOrderComponent } from './components/order/create/create.component';

const routes: Routes = [
  {path: '', redirectTo: 'order',pathMatch: 'full'},
  { path: 'product', component: ProductComponent },
  { path: 'order', component: OrderViewComponent ,
  },
  {path: 'order/create', component: CreateOrderComponent }
  ,{ path: 'shipment', component: ShipmentViewComponent },
  { path: 'customer', component: CustomerViewComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
