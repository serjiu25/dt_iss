import {User} from './user.model';
import {Paper} from './paper.model';

export class Submision {
  author?: User;
  paper?: Paper;
  conferenceId?: number;
}
