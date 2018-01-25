import java.util.*;

public class User{

  private String username;
  private String password;
  private String userType;

  public User(String username, String password, String userType){
  this.username = username;
  this.password = password;
  this.userType = userType;
  }
  public User(){

  }
  public void setUsername(String username){
    this.username = username;
  }
  public String getPassword(){
    return password;
  }
  public void setPassword(String password){
    this.password = password;
  }
  public String getUsername(){
    return username;
  }
  public void setUserType(String userType){
    this.userType = userType;
  }
  public String getUserType(){
    return userType;
  }
}
