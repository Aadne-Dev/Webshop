import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { Injectable } from '@angular/core';
import { HttpClient, provideHttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-browser',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './browser.html',
  styleUrls: ['../../../node_modules/bootstrap/dist/css/bootstrap.min.css', './browser.scss']
})
export class Browser implements OnInit {
  constructor(private http: HttpClient) {}
  
  products: any[] = [];

  getProducts(): Observable<any> {
    return this.http.get('/api/products');
  }

  ngOnInit() {
    this.getProducts().subscribe(data => {
      this.products = data;
    });
  }
}