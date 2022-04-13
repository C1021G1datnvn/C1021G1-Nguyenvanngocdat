import {Component, OnInit} from '@angular/core';
import {TodoServiceService} from "../service/todo-service.service";
import {Todo} from "../todo";


@Component({
  selector: 'app-list-todo',
  templateUrl: './list-todo.component.html',
  styleUrls: ['./list-todo.component.css']
})
export class ListTodoComponent implements OnInit {
  listTodo: Todo[];
  todoDelete : Todo;
  constructor(private todoService: TodoServiceService) {
  }

  ngOnInit():void {
    this.todoService.getAll().subscribe(data => {
      this.listTodo = data;
    })
  }

  delete(id:number) {
    this.todoService.delete(id).subscribe(() => {
      this.ngOnInit();
    })
  }

  getValueDelete(id: number) {
    this.todoService.findById(id).subscribe(data => {
      this.todoDelete = data;
    })
  }


}
