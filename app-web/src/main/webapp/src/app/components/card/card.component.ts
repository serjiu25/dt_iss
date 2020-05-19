import {Component, Input, OnInit} from '@angular/core';
import {Conference} from '../../models/conference.model';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.scss']
})
export class CardComponent implements OnInit {
  @Input() conference: Conference;
  constructor() { }

  ngOnInit(): void {
  }

}
