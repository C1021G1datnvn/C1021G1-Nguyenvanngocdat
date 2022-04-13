import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from '@angular/router';
import {ListProductComponent} from './list-product/list-product.component';
import {CreateProductComponent} from './create-product/create-product.component';
import {ProductUpdateComponent} from './product-update/product-update.component';

const routes: Routes = [
  {
    path: 'list', component: ListProductComponent
  }, {
  path: 'create', component: CreateProductComponent
  },
  {
    path: 'edit/:id', component: ProductUpdateComponent
  }
];
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports: [RouterModule]
})
export class AppRoutingModule { }
