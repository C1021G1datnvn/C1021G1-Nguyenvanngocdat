import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { StudentComponent } from './student/student.component';
import { StudentChildComponent } from './student-child/student-child.component';
import {CommonModule} from "@angular/common";

@NgModule({
  declarations: [
    AppComponent,
    StudentComponent,
    StudentChildComponent,
  ],
  imports: [
    BrowserModule,
    CommonModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
