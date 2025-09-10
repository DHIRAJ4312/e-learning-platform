import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-course-list',
  template: `
  <div>
    <h3>Courses</h3>
    <ul>
      <li *ngFor='let c of courses'>{{c.title}} - {{c.description}}</li>
    </ul>
  </div>`
})
export class CourseListComponent implements OnInit {
  courses: any[] = [];
  constructor(private http: HttpClient) {}
  ngOnInit(){ this.http.get<any[]>('http://localhost:8080/api/courses').subscribe(r => this.courses = r); }
}
