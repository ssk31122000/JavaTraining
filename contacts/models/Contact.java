package models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {
  
    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    public Contact(String name, String phoneNumber, String birthDate) throws ParseException{
        if(name==null || name.isBlank()){
            throw new IllegalArgumentException("Name cannot be null or Blank");
        }
        if(phoneNumber==null || phoneNumber.length()<5 || phoneNumber.isBlank()){
            throw new IllegalArgumentException("Phone Number cannot be null or less than 5 digits.");
        }
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.birthDate=birthDate;
        this.age=toAge(birthDate);
    }

    public Contact(Contact source){
        this.name=source.name;
        this.phoneNumber=source.phoneNumber;
        this.birthDate=source.birthDate;
        this.age=source.age;
    }


    public String getName(){
        return this.name;
    }

    public String getPhoneNumber(){
        return this.phoneNumber;
    }

    public String getBirthDate(){
        return this.birthDate;
    }

    public int getAge(){
        return this.age;
    }

    public void setName(String name){
        if(name==null || name==""){
            throw new IllegalArgumentException("Name cannot be null or Blank");
        }
        this.name=name;
    }

    public void setPhoneNumber(String phoneNumber){
        if(phoneNumber==null || phoneNumber.length()<5){
            throw new IllegalArgumentException("Phone Number cannot be null or less than 5 digits.");
        }
        this.phoneNumber=phoneNumber;

    }

    public void setBirthDate(String birthDate) throws ParseException{
        this.birthDate=birthDate;
        setAge(toAge(birthDate));
    }

    private void setAge(int age){
        this.age=age;
    }

    public int toAge(String birthDate) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
        formatter.setLenient(false);
        long diff = new Date().getTime()-formatter.parse(birthDate).getTime();
        return (int)(TimeUnit.MILLISECONDS.toDays(diff)/365);
    }

    public String toString(){
        return "Name: " + this.name + "\n" +
        "Phone number: " + this.phoneNumber + "\n" +
        "Birth Date: " + this.birthDate + "\n" +
        "Age: " + this.age + " year old\n";
    }
  
  
  

}
