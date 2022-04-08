import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators} from "@angular/forms";
import {Register} from "../register";

@Component({
  selector: 'app-register-component',
  templateUrl: './register-component.component.html',
  styleUrls: ['./register-component.component.css']
})
export class RegisterComponentComponent implements OnInit {
  registerForm : FormGroup;

  // @ts-ignore
  register: Register;

  constructor() { }

  ngOnInit(): void {
    this.registerForm = new FormGroup({
      email: new FormControl('', [Validators.required, Validators.email]),
      password: new FormControl('', [Validators.required,Validators.minLength(6)]),
      country: new FormControl('', Validators.required),
      age: new FormControl('', [Validators.required,Validators.min(18)]),
      phone: new FormControl('', Validators.pattern(/^\+84\d{9,10}$/))
    })
  }



}
