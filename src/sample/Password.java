package sample;

public class Password {
    private String siteTitle;
    private String userName;
    private String password;
    private String url;
    private String notes;

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getPassword() {
        return password;
    }

    public String getSiteTitle() {
        return siteTitle;
    }

    public String getUrl() {
        return url;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setSiteTitle(String siteTitle) {
        this.siteTitle = siteTitle;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void Password(){};

    public void Password(String password, String userName){
        this.password = password;
        this.userName = userName;
    }

    public String toString(){
        String s = String.format("***Entry:\n%s\n%s\n%s\n%s\n%s\nEnd***", getSiteTitle(), getUserName(), getPassword(), getUrl(), getNotes());


        return s;
    }

}
