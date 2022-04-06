import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-student-child',
  templateUrl: './student-child.component.html',
  styleUrls: ['./student-child.component.css']
})
export class StudentChildComponent implements OnInit {
  color: String = "blue";
  // @ts-ignore
  student : Student = {
    id: 1,
    name: "Đạt",
    address: "Đà Nẵng",
    age: 18,
    mark: 7
  }
  constructor() { }

  ngOnInit(): void {
  }
  changMark(mark: string) {
    this.student.mark = mark;
  }

}
