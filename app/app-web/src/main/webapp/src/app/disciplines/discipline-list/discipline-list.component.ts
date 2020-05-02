import {Component, OnInit} from '@angular/core';
import {DisciplineService} from "../shared/discipline.service";
import {Discipline} from "../shared/discipline.model";

@Component({
  selector: 'app-discipline-list',
  templateUrl: './discipline-list.component.html',
  styleUrls: ['./discipline-list.component.css']
})
export class DisciplineListComponent implements OnInit {
  disciplines: Discipline[];

  constructor(private disciplineService: DisciplineService) {
  }

  ngOnInit(): void {
    this.disciplineService.getDisciplines()
      .subscribe(disciplines => this.disciplines = disciplines);
  }

}
