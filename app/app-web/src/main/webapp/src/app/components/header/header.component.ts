import {Component, EventEmitter, OnInit, Output} from '@angular/core';
import {AuthService} from '../../services/auth.service';
import {UserService} from "../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.scss']
})
export class HeaderComponent implements OnInit {
  username = 'Name';
  @Output() repopulate = new EventEmitter<void>();
  pcProfile: boolean;
  constructor(
    private authService: AuthService,
    private userService: UserService,
    private router: Router
  ) {
  }

  ngOnInit(): void {
    this.authService.getCurrentUser().subscribe(user => this.username = user.name);
    this.pcProfile = this.userService.isPcProfile();
  }

  setAuthorProfile() {
    this.userService.setAuthorProfile();
    this.repopulate.emit();
  }

  setPcProfile() {
    this.userService.setPcProfile();
    this.repopulate.emit();
  }

  logout() {
    this.authService.logout();
    this.router.navigate(["/auth"]);
  }
}
