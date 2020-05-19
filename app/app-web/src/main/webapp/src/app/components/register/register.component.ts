import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';
import { User } from 'src/app/models/user.model';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {
  @Output() switchComponent = new EventEmitter<boolean>();

  email = '';
  password = '';
  lastName = '';
  firstName = '';
  affiliation = '';
  errors: String[];

  constructor(
    private authService: AuthService,
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  onSubmit(){
    this.errors = new Array<String>();
    this.authService.register(this.email, this.password, this.firstName, this.lastName, this.affiliation).subscribe(
      isRegistered => {
        if (isRegistered) {
          this.router.navigate(['/all-conferences']);
        } else {
          this.errors.push('Email already in use');
        }
      },
      err => console.error(err)
    );
  }

  goToLogin() {
    this.switchComponent.emit(true);
  }
}
