import { Component, inject, signal } from '@angular/core';
import { HttpClient, HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'login-root',
  standalone: true,
  imports: [HttpClientModule, FormsModule],
  templateUrl: './login.html',
  styleUrl: './login.css'
})
export class Login {

  protected username: string = "";

  protected password: string = "";

  protected alertMessage: string = "";

  // Dependency injection
  public http = inject(HttpClient);

  alertVisible = signal(false);

  public showAlert(): void {  
    this.alertVisible.set(true);
  }

  ngOnInit() {
    console.log("init");
  }

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
      this.showAlert();
    });
  }
}
