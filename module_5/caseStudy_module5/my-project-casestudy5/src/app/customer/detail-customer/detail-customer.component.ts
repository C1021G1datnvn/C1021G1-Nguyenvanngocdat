import { Component, OnInit } from '@angular/core';
import {CustomerDao} from "../CustomerDao/CustomerDao";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerInterface} from "../model/CustomerInterface";

@Component({
  selector: 'app-detail-customer',
  templateUrl: './detail-customer.component.html',
  styleUrls: ['./detail-customer.component.css']
})
export class DetailCustomerComponent implements OnInit {
  customerId : number;
    customer: CustomerInterface;
  constructor(private customerDao: CustomerDao, private route: ActivatedRoute, private router: Router) {
    console.log(this.route.snapshot.paramMap.get('id'))
    this.customerId = Number(this.route.snapshot.paramMap.get('id'))
  }

  ngOnInit(): void {
    this.customer = this.customerDao.getInformation(this.customerId);
  }

}
