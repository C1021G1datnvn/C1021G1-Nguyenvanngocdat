import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {EmployeeDao} from "../employeeDao/EmployeeDao";

@Component({
  selector: 'app-create-employee',
  templateUrl: './create-employee.component.html',
  styleUrls: ['./create-employee.component.css']
})
export class CreateEmployeeComponent implements OnInit {
  employeeCreate: FormGroup = new FormGroup({
    id: new FormControl('', Validators.required),
    name: new FormControl('', [Validators.required, Validators.maxLength(50)]),
    birthday: new FormControl(''),
    card: new FormControl('',[Validators.required, Validators.pattern( "^([0-9]{9})|([0-9]{12})$")]),
    phone: new FormControl('', [Validators.required, Validators.pattern("^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$")]),
    email: new FormControl('', [Validators.required, Validators.email]),
    level: new FormControl('', Validators.required),
    position: new FormControl(''),
    salary: new FormControl('', Validators.min(500)),
  })

  constructor() { }

  ngOnInit(): void {


  }

  createEmployee() {
    EmployeeDao.employeeList.push(this.employeeCreate.value);
  }
}
