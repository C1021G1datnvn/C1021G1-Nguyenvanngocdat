import {Component, OnInit} from '@angular/core';



@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {
  color: String = "blue";
  // @ts-ignore
  student : Student = {
    id: 1,
    name: "Đạt",
    address: "Đà Nẵng",
    age: 18,
    mark: 7
}
  constructor() {
  }

  ngOnInit(): void {
  }

  changMark(mark: string) {
    this.student.mark = mark;
  }
}
