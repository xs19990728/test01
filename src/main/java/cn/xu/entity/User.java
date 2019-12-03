package cn.xu.entity;

public class User {

    private String username;

    private String upwd;
    public User(String username, String passowrd) {
        this.username = username;
        this.upwd = passowrd;
    }
    public User() {

    }

    @Override
    public String toString() {
        return "username:"+getUsername()+"  password:"+getUpwd();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUpwd() {
        return upwd;
    }

    public void setUpwd(String upwd) {
        this.upwd = upwd;
    }
}
