import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {Router} from '@angular/router';

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
  constructor(private authService: AuthService,
              private router: Router) { }

  ngOnInit(): void {
  }
  goToLogin() {
    this.switchComponent.emit(true);
  }
  onSubmit(){
    console.log('registered');
  }
}
