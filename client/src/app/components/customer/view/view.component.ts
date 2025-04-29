import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { MatTableDataSource } from '@angular/material/table';
import { CustomerService } from '../../../data/services/customer.service';
import { Customer } from '../../../data/types/customer';

@Component({
  selector: 'app-view',
  templateUrl: './view.component.html',
  styleUrl: './view.component.scss'
})
export class CustomerViewComponent implements OnInit, AfterViewInit{
  displayedColumns: string[] = ['id', 'name','phone', 'address'];
  dataSource!: MatTableDataSource<Customer>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private customerService:CustomerService) {}

  ngOnInit() {
    this.customerService.getAll().subscribe((data: Customer[]) => {
      this.dataSource = new MatTableDataSource<Customer>(data);
      this.dataSource.paginator = this.paginator;
      this.dataSource.sort = this.sort;
    });
  }
  ngAfterViewInit() {
  }
  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();

    if (this.dataSource.paginator) {
      this.dataSource.paginator.firstPage();
    }
  }
}
