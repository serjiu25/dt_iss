package domain;

import java.util.List;

public class Paper {
    private String name;
    private String URL;
    private List<String> keywords;
    private List<String> topics;
    private List<String> other_authors;

    public Paper(String name, String URL, List<String> keywords, List<String> topics, List<String> other_authors) {
        this.name = name;
        this.URL = URL;
        this.keywords = keywords;
        this.topics = topics;
        this.other_authors = other_authors;
    }

    public String getName() {
        return name;
    }

    public String getURL() {
        return URL;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public List<String> getTopics() {
        return topics;
    }

    public List<String> getOther_authors() {
        return other_authors;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public void setOther_authors(List<String> other_authors) {
        this.other_authors = other_authors;
    }

    @Override
    public String toString() {
        return "Paper{" +
                "name='" + name + '\'' +
                ", URL='" + URL + '\'' +
                ", keywords=" + keywords +
                ", topics=" + topics +
                ", other_authors=" + other_authors +
                '}';
    }
}
