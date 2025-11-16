import { Component, signal } from '@angular/core';


@Component({
  selector: 'login-root',
  standalone: true,
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {
  alertVisible = signal(false);

  showAlert() {
    this.alertVisible.set(true);
  }
}
