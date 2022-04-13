import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {ListTodoComponent} from "./list-todo/list-todo.component";
import {CreateTodoComponent} from "./create-todo/create-todo.component";


const routes: Routes = [
  {
    path: "", component: ListTodoComponent
  },
  {
    path: "createTodo", component: CreateTodoComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
