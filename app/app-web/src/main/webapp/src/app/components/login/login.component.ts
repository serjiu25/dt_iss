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
  errors: String[];

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit() {
    this.errors = new Array<String>();
    this.authService.login(this.email, this.password).subscribe(isLogged => {
      if (isLogged) {
        this.router.navigate(['/all-conferences']);
      } else {
        this.errors.push('Invalid email/password combination');
      }
    },
      (error) => console.error(error));
  }

  goToRegister() {
    this.switchComponent.emit(true);
  }

}
