import { Injectable } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {map} from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CategoryServiceService {
  private readonly URL = 'http://localhost:3000/category';
  constructor(private http: HttpClient) {}
  getAll(): Observable<any>{
    return this.http.get(this.URL);
  }
}
