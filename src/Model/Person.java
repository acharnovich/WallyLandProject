package Model;

/**
 * The person class creates profile with a user's personal information 
 * @author tpn352
 */
public class Person{
    
     private String name;
     private String email;
     private String dateOfBirth;

   
   /**
     * Default  constructor for Person
    */
public Person(){
      
      this.name = this.name;
      this.email = this.email;
      this.dateOfBirth = this.dateOfBirth;

}

/**
 * All parameter constructor for Person
     * @param name name of person
     * @param email email of person
     * @param dateOfBirth birthday of person
 */     
  public Person(String name, String email, String dateOfBirth){
      
      this.name = name;
      this.email = email;
      this.dateOfBirth = dateOfBirth;

     
  
  }

  
/**
 * Get the name of person
 * @return String type name
 */
    public String getName() {
        return name;
    }
/**
 * Set the name of person
     * @param name String type name
 * 
 */
    public void setName(String name) {
        this.name = name;
    }

    /**
 * Get the email of person
 * @return String type email
 */
    public String getEmail() {
        return email;
    }

    /**
 * Set the email of person
     * @param email String type email
 * 
 */
    public void setEmail(String email) {
        this.email = email;
    }

 
/**
 * Get the birthday of person
 * @return String type date 
 */
    public String getDateOfBirth() {
        return dateOfBirth;
    }

/**
 * Set the birthday of person
 * @param dateOfBirth String type birthday
 * 
 */
    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }



    /**
     * View the instance of a person 
     *
     * @return Represents person object as a string
     */    
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", email=" + email + ", dateOfBirth=" + dateOfBirth + '}';
    }

    
        
    
}
    

