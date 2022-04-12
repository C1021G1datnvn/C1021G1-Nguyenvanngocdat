import {Injectable} from '@angular/core';
import {IWord} from "../iword";

@Injectable({
  providedIn: 'root'
})
export class DictionaryServiceService {
  word: IWord [] = [
    {
      word: "hello",
      mean: "xin chào",
    },
    {
      word: "beautiful",
      mean: "tuyệt vời",
    },
    {
      word: "strong",
      mean: "mạnh mẽ",
    },
    {
      word: "water",
      mean: "nước",
    },
    {
      word: "dragonfly",
      mean: "chuồn chuồn",
    },
    {
      word: "dog",
      mean: "chs",
    },
    {
      word: "cat",
      mean: "mèo",
    },
    {
      word: "smile'",
      mean: "cười",
    }
  ]

  constructor() {
  }

  getAll() {
    return this.word;
  }

  search(word:string){
    for (let i = 0; i< this.word.length;i++){
      if (this.word[i].word===word){
        return this.word[i];
      }
    }
  }

}
