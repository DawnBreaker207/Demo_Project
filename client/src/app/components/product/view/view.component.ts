import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';
import { Product } from '../../../data/types/product';
import { MatTableDataSource } from '@angular/material/table';
import { MatPaginator } from '@angular/material/paginator';
import { MatSort } from '@angular/material/sort';
import { ProductService } from '../../../data/services/product.service';
import { filter } from 'rxjs';

@Component({
  selector: 'app-product-view',
  templateUrl: './view.component.html',
  styleUrl: './view.component.scss',
})
export class ProductViewComponent implements OnInit, AfterViewInit {
  displayedColumns: string[] = ['id', 'name','price','is_delete','action'];
  dataSource!: MatTableDataSource<Product>;

  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  constructor(private productService: ProductService) {}
loadData(){
  this.productService.getAll().subscribe((data: Product[]) => {
    this.dataSource = new MatTableDataSource<Product>(data);
    this.dataSource.paginator = this.paginator;
    this.dataSource.sort = this.sort;
  });
}
  ngOnInit() {
 this.loadData();
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

  deleteProduct(id: string | number){
      this.productService.delete(id as number).subscribe(()=> this.loadData());
  }
}
