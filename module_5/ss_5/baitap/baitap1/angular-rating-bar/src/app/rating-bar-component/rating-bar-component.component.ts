import {Component, EventEmitter, Input, OnInit, Output, SimpleChanges} from '@angular/core';
import {IRatingUnit} from "../irating-unit";

@Component({
  selector: 'app-rating-bar-component',
  templateUrl: './rating-bar-component.component.html',
  styleUrls: ['./rating-bar-component.component.css']
})
export class RatingBarComponentComponent implements OnInit {
  @Input() max = 10;
  @Input() ratingValue = 3;
  @Input() showRatingValue = true;
  @Output() rateChange = new EventEmitter<String>();
  RatingUnits: Array<IRatingUnit> = [];

  constructor() {
  }

  ngOnChanges(changes: SimpleChanges) {
    if ('max' in changes) {
      let max = changes.max.currentValue;
      max = typeof max === 'undefined' ? 3 : max;
      this.max = max;
      this.calculate(max, this.ratingValue);
    }
  }

  ngOnInit() {
    this.calculate(this.max, this.ratingValue);
  }

  private calculate(max, ratingValue) {
    this.RatingUnits = Array.from({length: max},
      (_, index) => ({
        value: index + 1,
        active: index < ratingValue
      }));
  }

  select(index) {
    this.ratingValue = index + 1;
    this.RatingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);

    // @ts-ignore
    this.rateChange.emit(this.ratingValue);
  }

  enter(index) {
    this.RatingUnits.forEach((item, idx) => item.active = idx <= index);
  }

  reset() {
    this.RatingUnits.forEach((item, idx) => item.active = idx < this.ratingValue);
  }
}
