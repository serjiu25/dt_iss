import {Injectable} from '@angular/core';

import {HttpClient} from "@angular/common/http";

import {Observable} from "rxjs";
import {Discipline} from "./discipline.model";


@Injectable()
export class DisciplineService {
  private disciplinesUrl = 'http://localhost:8080/api/disciplines';

  constructor(private httpClient: HttpClient) {
  }

  getDisciplines(): Observable<Discipline[]> {
    return this.httpClient
      .get<Array<Discipline>>(this.disciplinesUrl);
  }

  // getStudent(id: number): Observable<Student> {
  //   return this.getStudents()
  //     .pipe(
  //       map(students => students.find(student => student.id === id))
  //     );
  // }
  //
  // update(student): Observable<Student> {
  //   const url = `${this.studentsUrl}/${student.id}`;
  //   return this.httpClient
  //     .put<Student>(url, student);
  // }

}
