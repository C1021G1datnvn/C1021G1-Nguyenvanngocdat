import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from "@angular/forms";
import {StudentDao} from "../StudentDao/StudentDao";
import {StudentInterface} from "../model/studentInterface";

@Component({
  selector: 'app-reactive-form',
  templateUrl: './reactive-form.component.html',
  styleUrls: ['./reactive-form.component.css']
})
export class ReactiveFormComponent implements OnInit {
  // @ts-ignore
  students: StudentInterface;
  studentCreate : FormGroup = new FormGroup({
      id: new FormControl('', Validators.required),
      name: new FormControl('', [Validators.required, Validators.maxLength(25)]),
      address: new FormControl('', Validators.required),
      age: new FormControl('', Validators.minLength(18)),
      mark: new FormControl('', Validators.required)
    }
  );
  constructor() { }

  ngOnInit(): void {
  }


  createStudent() {
    StudentDao.students.push(this.studentCreate.value);
    // console.log(this.studentCreate)
  }
}
