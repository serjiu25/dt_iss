export class Conference {
  id: number;
  title: string;
  body: string;

  constructor(_id, _title, _body) {
    this.id = _id;
    this.title = _title;
    this.body = _body;
  }
}
