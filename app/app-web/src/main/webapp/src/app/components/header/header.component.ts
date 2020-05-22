import {Component, OnInit} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  username = 'Name';

  constructor(
    private authService: AuthService,
    private userService: UserService
  ) {
  }

  ngOnInit(): void {
    this.authService.getCurrentUser().subscribe(user => this.username = user.name);
  }

  setAuthorProfile(): void {
    this.userService.setAuthorProfile();
  }

  setPcProfile(): void {
    this.userService.setPcProfile();
  }

}
