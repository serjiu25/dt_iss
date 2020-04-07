package dt.cms.domain;

import java.util.List;

public class Section {
    private User chair;
    private List<User> speakers;
    private List<User> listener;
    private String room;

    public Section(User chair, List<User> speakers, List<User> listener, String room) {
        this.chair = chair;
        this.speakers = speakers;
        this.listener = listener;
        this.room = room;
    }

    public User getChair() {
        return chair;
    }

    public void setChair(User chair) {
        this.chair = chair;
    }

    public List<User> getSpeakers() {
        return speakers;
    }

    public void setSpeakers(List<User> speakers) {
        this.speakers = speakers;
    }

    public List<User> getListener() {
        return listener;
    }

    public void setListener(List<User> listener) {
        this.listener = listener;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Section{" +
                "chair=" + chair +
                ", speakers=" + speakers +
                ", listener=" + listener +
                ", room='" + room + '\'' +
                '}';
    }
}
