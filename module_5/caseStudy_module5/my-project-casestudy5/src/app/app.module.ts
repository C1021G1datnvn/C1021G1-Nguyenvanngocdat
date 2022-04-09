import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomePageComponent } from './home/home-page/home-page.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { ListEmployeeComponent } from './employee/list-employee/list-employee.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './customer/create-customer/create-customer.component';
import { CreateEmployeeComponent } from './employee/create-employee/create-employee.component';
import { EditEmployeeComponent } from './employee/edit-employee/edit-employee.component';
import { DetailCustomerComponent } from './customer/detail-customer/detail-customer.component';
import { ListServiceComponent } from './service/list-service/list-service.component';

@NgModule({
  declarations: [
    AppComponent,
    HomePageComponent,
    ListCustomerComponent,
    HeaderComponent,
    FooterComponent,
    ListEmployeeComponent,
    EditCustomerComponent,
    CreateCustomerComponent,
    CreateEmployeeComponent,
    EditEmployeeComponent,
    DetailCustomerComponent,
    ListServiceComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
