import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

@Component({
  selector: 'app-browser',
  standalone: true,
  imports: [CommonModule, RouterModule],
  templateUrl: './browser.html',
  styleUrls: ['../../../node_modules/bootstrap/dist/css/bootstrap.min.css', './browser.scss']
})
export class Browser {
  products = [
    { name: 'Health Potion', price: 19, image: 'https://via.placeholder.com/300x200' },
    { name: 'Grand Health Potion', price: 29, image: 'https://via.placeholder.com/300x200' },
    { name: 'Invisibility Potion', price: 99, image: 'https://via.placeholder.com/300x200' },
    { name: 'Maga Potion', price: 49, image: 'https://via.placeholder.com/300x200' }
  ];
}
