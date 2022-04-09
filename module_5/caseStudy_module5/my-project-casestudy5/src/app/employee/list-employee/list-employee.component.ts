import { Component, OnInit } from '@angular/core';
import {EmployeeDao} from "../employeeDao/EmployeeDao";
import {EmployeeInterface} from "../model/EmployeeInterface";

@Component({
  selector: 'app-list-employee',
  templateUrl: './list-employee.component.html',
  styleUrls: ['./list-employee.component.css']
})
export class ListEmployeeComponent implements OnInit {
  employeeDelete: EmployeeInterface;
  listEmployee : EmployeeInterface[] = EmployeeDao.employeeList;
  constructor() { }

  ngOnInit(): void {
  }

  deleteEmployee(id:number) {
    this.listEmployee.splice(id-1, 1)
  }

  getValue(employee: EmployeeInterface) {
    this.employeeDelete = employee;
  }
}
