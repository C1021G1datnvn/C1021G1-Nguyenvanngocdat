import { Component, OnInit } from '@angular/core';
import {ProductService} from "../product/service/product.service";
import {FormControl, FormGroup} from "@angular/forms";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../model/product";

@Component({
  selector: 'app-product-update-component',
  templateUrl: './product-update-component.component.html',
  styleUrls: ['./product-update-component.component.css']
})
export class ProductUpdateComponentComponent implements OnInit {
  productForm: FormGroup;
  productEdit: Product;
  id: number;
  constructor(private productService: ProductService,
              private activatedRoute: ActivatedRoute,
              private router: Router) {


  }

  ngOnInit(): void {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = parseInt(paramMap.get('id'));
      console.log(this.id);
      this.productEdit = this.productService.findById(this.id);
  });
    this.productForm = new FormGroup({
      id: new FormControl(this.productEdit.id),
      name: new FormControl(this.productEdit.name),
      price: new FormControl(this.productEdit.price),
      description: new FormControl(this.productEdit.description),
    });
  }
  ongSubmit() {
    console.log(this.productForm.value);
    this.productService.updateProduct(this.id, this.productForm.value);
  }
}
