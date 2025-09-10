import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-login',
  template: `
  <div>
    <h3>Login</h3>
    <input [(ngModel)]='email' placeholder='email' name='email'>
    <input [(ngModel)]='password' placeholder='password' name='password' type='password'>
    <button (click)='login()'>Login</button>
    <div *ngIf='error'>{{error}}</div>
  </div>
  `
})
export class LoginComponent {
  email='';
  password='';
  error='';
  constructor(private http: HttpClient) {}
  login(){
    this.http.post<any>('http://localhost:8080/api/auth/login',{email:this.email,password:this.password}).subscribe({
      next: r => { localStorage.setItem('token', r.token); location.reload(); },
      error: e => this.error = e.error?.error || 'Login failed'
    });
  }
}
