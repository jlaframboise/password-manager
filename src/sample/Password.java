package sample;

public class Password {
    private String password;
    private String siteName;
    private String url;
    private String userName;
    private String firstName;
    private String lastName;

    public String getPassword() {
        return password;
    }

    public String getSiteName() {
        return siteName;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void Password(){};

    public void Password(String password, String userName){
        this.password = password;
        this.userName = userName;
    }

    public String toString(){
        String s = String.format("||%s||%s||%s", getSiteName(), getUserName(), getPassword());
        return s;
    }

}
