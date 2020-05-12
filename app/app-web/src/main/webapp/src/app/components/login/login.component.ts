import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  @Output() switchComponent = new EventEmitter<boolean>();

  email = '';
  password = '';
  hasErrors = false;
  error = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.authService.login(this.email, this.password).subscribe(isLogged => {
      if (isLogged) {
        this.router.navigate(['']);
      } else {
        this.hasErrors = true;
        this.error = 'Invalid email/password combination';
      }
    },
      (error) => console.error(error));
  }

  goToRegister() {
    this.switchComponent.emit(true);
  }

}
