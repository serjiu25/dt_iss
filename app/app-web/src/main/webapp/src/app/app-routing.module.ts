import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {AuthComponent} from './components/auth/auth.component';
import {AllConferencesComponent} from './components/all-conferences/all-conferences.component';
import {HomeComponent} from './components/home/home.component';
import {ConferenceComponent} from "./components/conference/conference.component";


const routes: Routes = [
  {path: '', redirectTo: 'auth', pathMatch: 'full'},
  {path: 'auth', component: AuthComponent},
  {path: 'all-conferences', component: AllConferencesComponent},
  {path: 'home', component: HomeComponent},
  {path: 'conference-page/:id', component: ConferenceComponent}
  // { path: 'home', redirectTo: 'all-conferences' }
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
