package domain;

public class User {
    private String name;
    private String affiliation;
    private String email;
    private String password;
    private Boolean admin;
    private Boolean validated;

    public User(String name, String affiliation, String email, String password, Boolean admin, Boolean validated) {
        this.name = name;
        this.affiliation = affiliation;
        this.email = email;
        this.password = password;
        this.admin = admin;
        this.validated = validated;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    public Boolean getValidated() {
        return validated;
    }

    public void setValidated(Boolean validated) {
        this.validated = validated;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", affiliation='" + affiliation + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", admin=" + admin +
                ", validated=" + validated +
                '}';
    }
}
