import {Component, OnInit} from '@angular/core';
import {StudentDao} from "../StudentDao/StudentDao";



@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {


  // @ts-ignore
  student : Student[] = StudentDao.students;
  constructor() {
  }

  ngOnInit(): void {
  }


}
