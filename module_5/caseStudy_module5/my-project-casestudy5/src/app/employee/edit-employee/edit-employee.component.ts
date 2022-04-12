import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";

@Component({
  selector: 'app-edit-employee',
  templateUrl: './edit-employee.component.html',
  styleUrls: ['./edit-employee.component.css']
})
export class EditEmployeeComponent implements OnInit {
  editEmployee : FormGroup = new FormGroup({
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

}
