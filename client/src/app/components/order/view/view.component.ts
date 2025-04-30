import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { clearParam } from '../../../core/utils/clear-param';
import { formatDateUtils } from '../../../core/utils/format-date';
import { OrderService } from '../../../data/services/order.service';
import { Order } from '../../../data/types/order';

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

  constructor(private orderService: OrderService, private fb : FormBuilder) {
    this.formQuery = this.fb.group({
      customerName: [],
      minTotal: [],
      maxTotal: [],
      orderStatus: [],
      paymentStatus: [],
      createFrom: [],
      createTo: [],
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
const createdForm = formatDateUtils( this.formQuery.controls['createFrom'].value);
const createdTo = formatDateUtils( this.formQuery.controls['createTo'].value);

// const formattedDate = createdTo ? this.datePipe.transform(createdTo, 'yyyy-MM-ddTHH:mm:ss'): null;

const params = {
  ...this.formQuery.value,
  createFrom: createdForm,
  createTo:createdTo
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
