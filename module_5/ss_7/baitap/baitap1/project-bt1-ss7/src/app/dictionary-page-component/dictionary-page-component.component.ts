import { Component, OnInit } from '@angular/core';
import {IWord} from "../iword";
import {DictionaryServiceService} from "../service/dictionary-service.service";

@Component({
  selector: 'app-dictionary-page-component',
  templateUrl: './dictionary-page-component.component.html',
  styleUrls: ['./dictionary-page-component.component.css']
})
export class DictionaryPageComponentComponent implements OnInit {
  showAllWord : IWord[];
  constructor(private wordService: DictionaryServiceService) {
    this.showAllWord = this.wordService.getAll();
  }

  ngOnInit(): void {
  }

}
