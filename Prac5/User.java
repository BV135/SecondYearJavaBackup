import java.util.ArrayList;

public class User {
  private String username;
  private String password;

  public User() {

  }

  public User(String username, String password) {
    this.username = username;
    this.password = password;

  }

  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public boolean isValidLogin(String username, String password) {
    ArrayList<User> users = new ArrayList<>();
    users.add(new User("Bonga", "Velem12"));
    users.add(new User("Kyrie", "Irving11"));
    for (User user : users) {
      if (user.getUsername().equals(username) && user.getPassword().equals(password))
        return true;
    }
    return false;

  }

  public String toString() {
    return "\nUsername: " + this.getUsername() + "Password: " + this.getPassword();

  }

}