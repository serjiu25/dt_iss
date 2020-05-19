export class Conference {
  id?: number;
  title?: string;
  description?: string;
  eventId?: number;

  constructor(id: number, title: string, description: string, eventId: number) {
    this.id = id;
    this.title = title;
    this.description = description;
    this.eventId = eventId;
  }
}
