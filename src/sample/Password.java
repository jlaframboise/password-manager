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

    public Password(){};



    public Password(String password, String userName){
        this.password = password;
        this.userName = userName;
    }

    public Password(String encryptedText, int shift){
        String plaintext = Encryption.decrypt(encryptedText, shift);
        String[] parts = plaintext.split("\n");
        this.setSiteTitle(parts[0]);
        this.setUserName(parts[1]);
        this.setPassword(parts[2]);
        this.setUrl(parts[3]);
        this.setNotes(parts[4]);
    }

    public String toString(){
        String s = String.format("<<Entry-Start\n%s\n%s\n%s\n%s\n%s\nEntry-End>>", getSiteTitle(), getUserName(), getPassword(), getUrl(), getNotes());

        return s;
    }

    public String toEncryptedString(int shift){
        String s = "<<Entry-Start\n" +
                Encryption.encrypt(String.format("%s\n%s\n%s\n%s\n%s", getSiteTitle(), getUserName(), getPassword(), getUrl(), getNotes()), shift) +
                "\nEntry-End>>";
        return s;
    }

}
