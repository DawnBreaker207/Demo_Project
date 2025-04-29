import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Order } from '../../../data/types/order';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { OrderService } from '../../../data/services/order.service';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { clearParam } from '../../../core/utils/clear-param';
import { DatePipe } from '@angular/common';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrl: './view.component.scss'
})
export class OrderViewComponent implements OnInit, AfterViewInit{
 displayedColumns: string[] = ['id', 'name','order_status','shipment_status','total','created_at'];
  dataSource!: MatTableDataSource<Order>;
formQuery!: FormGroup;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private orderService: OrderService, private fb : FormBuilder, private datePipe: DatePipe) {
    this.formQuery = this.fb.group({
      customerName: [],
      total: [],
      orderStatus: [],
      paymentStatus: [],
      createdAt: []
    });
  }

  ngOnInit() {
    this.orderService.getAll().subscribe((data: Order[]) => {
      this.dataSource = new MatTableDataSource<Order>(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }
  ngAfterViewInit() {
  }
  applyFilter =() => {
const createdAt = this.formQuery.controls['createdAt'].value;

const formattedDate = createdAt ? this.datePipe.transform(createdAt, 'yyyy-MM-ddTHH:mm:ss'): null;

const params = {
  ...this.formQuery.value,
  createdAt: formattedDate
}
    const filterValues = params;
    const cleanedValue = clearParam(filterValues);
  this.orderService.getAll(cleanedValue).subscribe(order => {
  this.dataSource = new MatTableDataSource<Order>(order);
  this.dataSource.paginator = this.paginator;
  this.dataSource.sort = this.sort;
})
  }

  clearFilter =() =>{
   this.formQuery.reset();
  }
}
