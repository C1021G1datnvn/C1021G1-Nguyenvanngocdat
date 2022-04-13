import { Component, OnInit } from '@angular/core';
import {Category} from '../category';
import {CategoryServiceService} from '../category-service.service';
import {FormControl, FormGroup} from '@angular/forms';
import {Product} from '../product';
import {ProductServiceService} from '../product-service.service';

@Component({
  selector: 'app-create-product',
  templateUrl: './create-product.component.html',
  styleUrls: ['./create-product.component.css']
})
export class CreateProductComponent implements OnInit {
  categoryList: Category[];
  createForm: FormGroup;
  category: Category;
  product: Product;
  currentProductArray: Product[];
  constructor(private service: CategoryServiceService, private productService: ProductServiceService){}

  ngOnInit(): void {
    this.getAll();
    this.createForm = new FormGroup({
      id: new FormControl(),
      name: new FormControl(),
      price: new FormControl(),
      category: new FormControl()
    });
  }
  getAll(){
    this.service.getAll().subscribe((par) => {
      this.categoryList = par;
    });
  }
  getById(id: number){
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.categoryList.length; i ++){
      // tslint:disable-next-line:triple-equals
      if (this.categoryList[i].id == id ){
        console.log(this.categoryList[i]);
        return this.categoryList[i];
      }
    }
  }
  add() {
    this.category = this.getById(this.createForm.value.category);
    console.log(this.category);
    // this.product.id = this.currentProductArray[this.currentProductArray.length - 1].id + 1;
    this.product = Object.assign({}, this.createForm.value);
    console.log(this.product);
    this.product.name = this.createForm.value.name;
    this.product.price = this.createForm.value.price;
    this.product.category = this.category;
    this.productService.saveProduct(this.product).subscribe(() => console.log('ok'),
      (err) => console.log(err));
  }
}
