import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { DatePipe } from '@angular/common';
import { HttpClientModule } from '@angular/common/http';
import { ReactiveFormsModule } from '@angular/forms';
import { MatButtonModule } from '@angular/material/button';
import { MatCheckboxModule } from '@angular/material/checkbox';
import { provideNativeDateAdapter } from '@angular/material/core';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatIconModule } from "@angular/material/icon";
import { MatInputModule } from '@angular/material/input';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSelectModule } from '@angular/material/select';
import { MatSortModule } from '@angular/material/sort';
import { MatTableModule } from '@angular/material/table';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerViewComponent } from './components/customer/view/view.component';
import { OrderViewComponent } from './components/order/view/view.component';
import { ProductViewComponent } from './components/product/view/view.component';
import { ShipmentViewComponent } from './components/shipment/view/view.component';
import { CheckTagsPipe } from './core/pipes/check-tags.pipe';
import { StatusTagsPipe } from './core/pipes/status-tags.pipe';
import { ProductComponent } from './pages/product/product.component';
import { CreateOrderComponent } from './components/order/create/create.component';


@NgModule({
  declarations: [AppComponent, ProductComponent,ProductViewComponent, CustomerViewComponent, OrderViewComponent, ShipmentViewComponent, StatusTagsPipe, CheckTagsPipe, CreateOrderComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatTableModule,
    MatInputModule,
    MatPaginatorModule,
    MatSortModule,
    MatFormFieldModule,
    HttpClientModule,
    MatButtonModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatInputModule,
    MatSelectModule,
    MatIconModule,
    MatCheckboxModule
  ],
  providers: [provideAnimationsAsync(), provideNativeDateAdapter(),DatePipe],
  bootstrap: [AppComponent],
})
export class AppModule {}
