import {User} from './user.model';

export class Evaluation {
  id?: number;
  result?: string;
  justification?: string;
  submissionId?: number;
  reviewer?: User;
}
