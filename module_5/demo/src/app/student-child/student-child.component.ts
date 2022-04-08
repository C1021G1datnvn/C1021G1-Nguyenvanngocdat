import {Component, Input, OnInit} from '@angular/core';
import {StudentInterface} from "../model/studentInterface";


@Component({
  selector: 'app-student-child',
  templateUrl: './student-child.component.html',
  styleUrls: ['./student-child.component.css']
})
export class StudentChildComponent implements OnInit {
  color: String = "blue";

  @Input()
    // @ts-ignore
  receive : StudentInterface;

  constructor() { }

  ngOnInit(): void {
  }
  changMark(mark: string) {
    // @ts-ignore
    this.receive.mark = mark;
  }

}
