import { Routes } from '@angular/router';
import { Browser } from './browser/browser';
import { Login } from './login/login';

export const routes: Routes = [
  { path: '', component: Browser },
  { path: 'login', component: Login },
];
