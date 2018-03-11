package ViewModels;

public class ProfileDataView {
    private String name;
    private String location;
    private String website;
    private String bio;

    public ProfileDataView(String name, String location, String website, String bio) {
        this.name = name;
        this.location = location;
        this.website = website;
        this.bio = bio;
    }

    public ProfileDataView() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}