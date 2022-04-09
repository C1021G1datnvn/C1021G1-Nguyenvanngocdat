import {Component, OnInit} from '@angular/core';
import {CustomerDao} from "../CustomerDao/CustomerDao";
import { Router} from "@angular/router";
import {CustomerInterface} from "../model/CustomerInterface";


@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {


  customerDelete: CustomerInterface;

  listCustomer: CustomerInterface[] = CustomerDao.customerList;

  constructor(private router:Router, private customerDao: CustomerDao) {
  }

  ngOnInit(): void {
  }

  deleteCustomer(id:number) {
    // this.listCustomer.splice(id-1,1)
    this.customerDao.deleteCustomer(id)
  }

  getValue(customer: CustomerInterface) {
    this.customerDelete = customer;
  }

}
