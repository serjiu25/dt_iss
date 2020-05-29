import {User} from './user.model';

export class ProgramCommittee {
  chair?: User;
  coChairs?: User[];
  reviewers?: User[];
  conferenceId?: number;

  chairId?: number;
  coChairsIds?: number[];
}
