import { Component, OnInit } from '@angular/core';
import {TodoServiceService} from "../service/todo-service.service";
import {Todo} from "../todo";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-create-todo',
  templateUrl: './create-todo.component.html',
  styleUrls: ['./create-todo.component.css']
})
export class CreateTodoComponent implements OnInit {
  todoCreate: FormGroup = new FormGroup({
      id: new FormControl(''),
      content: new FormControl(''),
      complete: new FormControl('')
  })
  constructor(private todoService : TodoServiceService,
              private router: Router) { }

  ngOnInit(): void {
  }
  createTodo() {
this.todoService.save(this.todoCreate.value).subscribe(() => {
  this.router.navigateByUrl("");
})
  }

}
