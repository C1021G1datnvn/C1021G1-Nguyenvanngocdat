import { Component, OnInit } from '@angular/core';
import {CategoryServiceService} from '../category-service.service';
import {Category} from '../category';
import {ActivatedRoute, ParamMap} from '@angular/router';
import {FormControl, FormGroup} from '@angular/forms';
import {ProductServiceService} from '../product-service.service';
import {Product} from '../product';

@Component({
  selector: 'app-product-update',
  templateUrl: './product-update.component.html',
  styleUrls: ['./product-update.component.css']
})
export class ProductUpdateComponent implements OnInit {
  id: number;
  idCategory: number;
  category: Category;
  categoryList: Category[];
  formGr: FormGroup;
  updateProduct: Product;
  products: Product[];
  constructor(private service: CategoryServiceService,
              private productService: ProductServiceService, private activated: ActivatedRoute) { }

  ngOnInit(): void {
    this.getAll();
    this.getIdUpdate();
    this.getAllProduct();
    console.log(this.id + 'id' );
    console.log(this.products + 'prrr');
  }
  getAll(){
    this.service.getAll().subscribe((par) => {
      this.categoryList = par;
    });
  }
  getAllProduct(){
    this.productService.getAll().subscribe((products) => {
      // tslint:disable-next-line:prefer-for-of
      for ( let i = 0; i < products.length; i++){
        // tslint:disable-next-line:triple-equals
        if ( products[i].id == this.id){
          this.createFormGroup(products[i]);
        }
      }
    });
  }
  getById(id: number){
    // tslint:disable-next-line:prefer-for-of
    for (let i = 0; i < this.categoryList.length; i ++){
      console.log(123);
      // tslint:disable-next-line:triple-equals
      if (this.categoryList[i].id == id ){
        console.log(234);
        console.log(this.categoryList[i]);
        return this.categoryList[i];
      }
    }
  }
  createFormGroup(update){
    this.formGr = new FormGroup({
      id: new FormControl(update.id),
      name: new FormControl(update.name),
      price: new FormControl(update.price),
      category: new FormControl(update.category)
    });
    console.log(this.formGr.value);
    // this.formGr.setValue(update);
  }
  getIdUpdate(){
    this.activated.paramMap.subscribe((par: ParamMap) => {
      this.id = Number(par.get('id'));
    });
  }
  add() {
    this.category = this.getById(this.idCategory);
    this.updateProduct = Object.assign({}, this.formGr.value);
    console.log(this.updateProduct);
    this.updateProduct.name = this.formGr.value.name;
    this.updateProduct.price = this.formGr.value.price;
    this.updateProduct.category = this.category;
    this.productService.updateCategory(this.updateProduct.id, this.updateProduct).subscribe(() => console.log('ok'),
      (err) => console.log(err));
  }
}
