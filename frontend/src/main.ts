import { bootstrapApplication } from '@angular/platform-browser';
import { appConfig } from './app/login/login.config';
import { App } from './app/app';
import { Login } from './app/login/login';

bootstrapApplication(Login, appConfig)
  .catch((err) => console.error(err));
