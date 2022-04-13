import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Todo} from "../todo";

@Injectable({
  providedIn: 'root'
})
export class TodoServiceService {
  URL = "http://localhost:3000/todo";

  constructor(private http : HttpClient) {}
    getAll(): Observable<Todo[]> {
      return this.http.get<Todo[]>(this.URL);
  }
  save(todo: Todo) {
    return this.http.post<Todo>(this.URL, todo);
  }
  delete(id:number) {
    return this.http.delete<Todo>(this.URL + '/' + id);
  }
  findById(id: number) {
    return this.http.get<Todo>(this.URL + '/' + id);
  }
}
