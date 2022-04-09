import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListCustomerComponent} from './customer/list-customer/list-customer.component';
import {HomePageComponent} from "./home/home-page/home-page.component";
import {ListEmployeeComponent} from "./employee/list-employee/list-employee.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";
import {CreateCustomerComponent} from "./customer/create-customer/create-customer.component";
import {CreateEmployeeComponent} from "./employee/create-employee/create-employee.component";
import {EditEmployeeComponent} from "./employee/edit-employee/edit-employee.component";
import {DetailCustomerComponent} from "./customer/detail-customer/detail-customer.component";
import {ListServiceComponent} from "./service/list-service/list-service.component";


const routes: Routes = [
  {
  path: "", component: HomePageComponent
  },
  {
    path: "listCustomer", component: ListCustomerComponent
  },
  {
    path:"listEmployee", component:ListEmployeeComponent
  },
  {
    path:"editCustomer", component:EditCustomerComponent
  },
  {
    path:"createCustomer", component:CreateCustomerComponent
  },
  {
    path:"createEmployee", component:CreateEmployeeComponent
  },
  {
    path:"editEmployee", component:EditEmployeeComponent
  },
  {
    path:"detailCustomer/:id", component:DetailCustomerComponent
  },
  {
    path:"listService", component:ListServiceComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
