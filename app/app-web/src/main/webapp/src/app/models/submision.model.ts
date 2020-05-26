import {User} from './user.model';
import {Paper} from './paper.model';

export class Submission {
  id?: number;
  author?: User;
  paper?: Paper;
  conferenceId?: number;
}
