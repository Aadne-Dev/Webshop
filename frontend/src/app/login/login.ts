import { Component, inject, signal } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { CommonModule, Location } from '@angular/common';
import { MatSnackBar } from '@angular/material/snack-bar';

@Component({
  selector: 'login-root',
  standalone: true,
  imports: [HttpClientModule, FormsModule, CommonModule],
  templateUrl: './login.html',
  styleUrl: './login.scss'
})
export class Login {

  protected username: string = "";

  protected password: string = "";

  protected alertMessage: string = "";

  // Dependency injection
  public http = inject(HttpClient);

  ngOnInit() {
    console.log("init");
  }

  constructor( private snackBar: MatSnackBar, private location: Location ) {}

  // Submit username and pwd, return JWT token (eventually). For now, just return the user inputs
  // to make sure the REST API works,
  public submitLogin() {
    console.log("POST request");

    // Must be /api/ to route to backend as defined in proxy.conf.json
    this.http.post("/api/login",
      { username: this.username, password: this.password },
      { responseType: 'text' }
    ).subscribe(response => {
      this.alertMessage = response;
      this.showToast(this.alertMessage);
    });
  }

  goBack() {
    this.location.back();
  }

  
  showToast(message: string) {
    this.snackBar.open(message, 'Close', {
      duration: 10000,
      horizontalPosition: 'center',
      verticalPosition: 'top'
    });
  }
}
