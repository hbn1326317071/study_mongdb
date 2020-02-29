package optional;

/**
 * @Description TODO
 * @Author huangbaoning
 * @Date 2020/2/23 9:04
 */
public class User {
    private String email;
    private String phone;

    public User(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
