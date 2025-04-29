import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Shipment } from '../../../data/types/shipment';
import { MatTableDataSource } from '@angular/material/table';
import { MatSort } from '@angular/material/sort';
import { MatPaginator } from '@angular/material/paginator';
import { ShipmentService } from '../../../data/services/shipment.service';

@Component({
  selector: 'app-shipment-view',
  templateUrl: './view.component.html',
  styleUrl: './view.component.scss'
})
export class ShipmentViewComponent implements OnInit,AfterViewInit {
  displayedColumns: string[] = ['id', 'status','amount','paid_at'];
  dataSource!: MatTableDataSource<Shipment>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private shipmentService: ShipmentService) {}

  ngOnInit() {
    this.shipmentService.getAll().subscribe((data: Shipment[]) => {
      this.dataSource = new MatTableDataSource<Shipment>(data);
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
