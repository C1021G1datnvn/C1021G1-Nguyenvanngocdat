import { Component, OnInit } from '@angular/core';
import {ProductServiceService} from '../product-service.service';
import {Product} from '../product';

@Component({
  selector: 'app-list-product',
  templateUrl: './list-product.component.html',
  styleUrls: ['./list-product.component.css']
})
export class ListProductComponent implements OnInit {
  productList: Product[];
  constructor(private service: ProductServiceService) { }

  ngOnInit(): void {
    this.getAll();
  }
  getAll(){
    this.service.getAll().subscribe((products) => {
      this.productList = products;
    });
  }

  delete(id: number) {
    this.service.delete(id).subscribe(() => console.log('od'));
    this.getAll();
  }
}
