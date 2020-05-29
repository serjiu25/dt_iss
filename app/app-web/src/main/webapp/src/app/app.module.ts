import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';
import {HttpClientModule} from '@angular/common/http';
import {FormsModule} from '@angular/forms';

import {AppComponent} from './app.component';
import {AppRoutingModule} from './app-routing.module';
import { AuthComponent } from './components/auth/auth.component';
import { LoginComponent } from './components/login/login.component';
import { RegisterComponent } from './components/register/register.component';
import { AuthService } from './services/auth.service';
import { AllConferencesComponent } from './components/all-conferences/all-conferences.component';
import {NgbPaginationModule, NgbAlertModule, NgbModule} from '@ng-bootstrap/ng-bootstrap';
import { CardComponent } from './components/card/card.component';
import { HeaderComponent } from './components/header/header.component';
import {ConferenceService} from './services/conference.service';
import { HomeComponent } from './components/home/home.component';
import {UserService} from "./services/user.service";
import { ProgramCommitteeService } from './services/programCommittee.service';
import { ConferenceComponent } from './components/conference/conference.component';
import { PaperCardComponent } from './components/paper-card/paper-card.component';
import { PaperService } from './services/paper.service';
@NgModule({
  declarations: [
    AppComponent,
    AuthComponent,
    LoginComponent,
    RegisterComponent,
    AllConferencesComponent,
    CardComponent,
    AllConferencesComponent,
    HeaderComponent,
    HomeComponent,
    ConferenceComponent,
    PaperCardComponent,
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgbModule,
  ],
  providers: [
    AuthService, 
    ConferenceService, 
    UserService,
    PaperService,
    ProgramCommitteeService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
