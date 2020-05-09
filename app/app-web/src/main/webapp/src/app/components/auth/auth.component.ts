import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-auth',
  templateUrl: './auth.component.html',
  styleUrls: ['./auth.component.scss']
})
export class AuthComponent implements OnInit {
  weAreOnLoginPage = true;

  constructor() { }

  ngOnInit(): void {
  }
  toggleComponents() {
    this.weAreOnLoginPage = !this.weAreOnLoginPage;
  }

}
