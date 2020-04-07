package domain;

import java.util.List;

public class Event {
    private List<Section> sections;

    public Event(List<Section> sections) {
        this.sections = sections;
    }

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    @Override
    public String toString() {
        return "Event{" +
                "sections=" + sections +
                '}';
    }
}
