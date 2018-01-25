import java.util.*;

public class Review{

  private String username;
  private String productname;
  private String manufacturer;
  private double price;
  private String type;
  private int userage;
  private String userOccupation;
  private String city;
  private int zip;
  private String state;
  private String gender;
  private int rating;
  private String rdate;
  private String review;

  public Review(String username,String productname,String manufacturer,double price,String type,int userage,String userOccupation,String city,int zip,String state,String gender,int rating,String rdate,String review){
  this.username=username;
  this.productname=productname;
  this.manufacturer=manufacturer;
  this.price=price;
  this.type=type;
  this.userage=userage;
  this.userOccupation=userOccupation;
  this.city=city;
  this.zip=zip;
  this.state=state;
  this.gender=gender;
  this.rating=rating;
  this.rdate=rdate;
  this.review=review;
  }
  public Review(){

  }
  public void setUsername(String username){
    this.username = username;
  }
  public String getUsername(){
    return username;
  }
   public void setUserOccupation(String username){
    this.userOccupation = userOccupation;
  }
  public String getUserOccupation(){
    return userOccupation;
  }

  public String getProductName(){
    return productname;
  }
  public void setProductName(String productname){
    this.productname = productname;
  }

  public void setManufacturer(String manufacturer){
    this.manufacturer = manufacturer;
  }
  public String getManufacturer(){
    return manufacturer;
  }

  public void setPrice(double price){
    this.price = price;
  }
  public double getPrice(){
    return price;
  }
  public void setType(String type){
    this.type = type;
  }
  public String getType(){
    return type;
  }

  public void setCity(String city){
    this.city = city;
  }
  public String getCity(){
    return city;
  }
  public void setState(String state){
    this.state = state;
  }
  public String getState(){
    return state;
  }
  public void setGender(String gender){
    this.gender = gender;
  }
  public String getGender(){
    return gender;
  }
  public void setDate(String rdate){
    this.rdate = rdate;
  }
  public String getDate(){
    return rdate;
  }
  public void setReview(String review){
    this.review = review;
  }
  public String getReview(){
    return review;
  }
  public void setZip(int zip){
    this.zip = zip;
  }
  public int getZip(){
    return zip;
  }

  public void setUAge(int userage){
    this.userage = userage;
  }
  public int getUAge(){
    return userage;
  }
  public void setRating(int rating){
    this.rating = rating;
  }
  public int getRating(){
    return rating;
  }

}
