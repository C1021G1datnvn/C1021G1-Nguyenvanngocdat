import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {
  number1 = 0;
  number2 = 0;
  action: string;
  result: number;

  constructor() {
  }

  ngOnInit(): void {
  }

  calculate() {
    switch (this.action) {
      case 'Add':
        this.result = this.number1 + this.number2;
      case 'Sub':
        this.result = this.number1 - this.number2;
        break;
      case 'Mul':
        this.result = this.number1 * this.number2;
        break;
      case 'Div':
        this.result = this.number1 / this.number2;
        break;
      default:
        this.result = 0;
        break;
    }
  }
}
