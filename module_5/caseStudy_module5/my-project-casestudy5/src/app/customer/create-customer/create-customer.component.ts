import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerDao} from "../CustomerDao/CustomerDao";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {

  createCustomer : FormGroup = new FormGroup({
    id: new FormControl(''),
    name: new FormControl('', Validators.required),
    birthday: new FormControl('',[Validators.required, Validators.pattern( "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$")]),
    gender: new FormControl(''),
    card: new FormControl('', [Validators.required, Validators.pattern( "^([0-9]{9})|([0-9]{12})$")]),
    phone: new FormControl('', [Validators.required, Validators.pattern("^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$")]),
    email: new FormControl('', [Validators.required, Validators.email]),
    customerType: new FormControl(''),
    address: new FormControl('', Validators.required)
  })

  constructor() { }

  ngOnInit(): void {

  }


  customerCreate() {
    CustomerDao.customerList.push(this.createCustomer.value);
  }
}
