package hziee.smvc.model;

public class User {
    private Integer userid;

    private String username;

    private Integer userAuthority;

    private String userPersonalFile;

    private String userPasswordHash;

    private String userEmail;

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Integer getUserAuthority() {
        return userAuthority;
    }

    public void setUserAuthority(Integer userAuthority) {
        this.userAuthority = userAuthority;
    }

    public String getUserPersonalFile() {
        return userPersonalFile;
    }

    public void setUserPersonalFile(String userPersonalFile) {
        this.userPersonalFile = userPersonalFile == null ? null : userPersonalFile.trim();
    }

    public String getUserPasswordHash() {
        return userPasswordHash;
    }

    public void setUserPasswordHash(String userPasswordHash) {
        this.userPasswordHash = userPasswordHash == null ? null : userPasswordHash.trim();
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail == null ? null : userEmail.trim();
    }
}