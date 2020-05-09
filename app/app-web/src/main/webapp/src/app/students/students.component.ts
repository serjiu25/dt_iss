import {Component} from "@angular/core";
import {StudentService} from "./shared/student.service";
import {Router} from "@angular/router";

@Component({
  // moduleId: module.id,
  selector: 'ubb-students',
  templateUrl: './students.component.html',
  styleUrls: ['./students.component.css'],
})
export class StudentsComponent {
  constructor(private router: Router) {
  }

  addNewStudent() {
    console.log("add new student btn clicked ");

    this.router.navigate(["student/new"]);
  }
}
