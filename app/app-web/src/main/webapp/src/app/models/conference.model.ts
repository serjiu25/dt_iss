import { ProgramCommittee } from './programCommittee.model';
import { Event } from './event.model';
import { Submission } from './submision.model';

export class Conference {
  id?: number;
  title?: string;
  description?: string;
  phase?: string;
  event?: Event;
  programCommittee?: ProgramCommittee;
  submissions?: Submission[];

  eventId?: number;
  programCommitteeId?: number;

  constructor(id?: number, title?: string, description?: string, eventId?: number, phase?: string) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.eventId = eventId;
    this.phase = phase;
  }
}
