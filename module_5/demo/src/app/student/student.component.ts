import {Component, OnInit} from '@angular/core';
import {StudentDao} from "../StudentDao/StudentDao";
import {StudentInterface} from "../model/studentInterface";



@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {


  sendValue: StudentInterface = {
    id: 1,
    name: "nguyễn văn ngọc đạt",
    address: "đà nẵng",
    age: 18,
    mark: 6
  };

  student : StudentInterface[] = StudentDao.students;


  constructor() {
  }

  ngOnInit(): void {
  }


}
