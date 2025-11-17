import { Component, signal } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ApiService } from './login-api-call';

@Component({
  selector: 'login-root',
  standalone: true,
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  // This is a temporary bit to showcase using snackBar toast messages, and connecting to the backend
  constructor(private snackBar: MatSnackBar, private api: ApiService) {}
  async apiCall() {
    try {
      this.api.getProducts().subscribe(data => {
        if (data=="200") {
          this.showToast("That password is already in use by: AdminRoot." );
        }
      });
    } catch (error) {
      this.showToast("API call failed" );
    }
  }
  showToast(message: string) {
    this.snackBar.open(message, 'Close', {
      duration: 10000,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }

  alertVisible = signal(false);

  showAlert() {
    this.alertVisible.set(true);
  }


}
