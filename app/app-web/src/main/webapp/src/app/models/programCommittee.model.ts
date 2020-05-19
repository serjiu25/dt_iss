import {User} from './user.model';

export class ProgramCommittee {
  chair?: User;
  coChairs?: Array<User>;
  conferenceId?: number;

}
