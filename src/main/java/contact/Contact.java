package contact;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Contact")
public class Contact implements Serializable {
   private static final long serialVersionUID = 1L;

   @Id
   @GeneratedValue(strategy=GenerationType.AUTO)
   Long id;
   
   public void setId(Long id) {
	this.id = id;
   }


   private String name;
   private String email;
   private String profession;
   private String location;

   // Constructors:
   public Contact() {
   }
   
   // Constructors:
   public Contact(String name,String email,String profession,String location) {
      this.name = name;
      this.email=email;
      this.profession=profession;
      this.location=location;
   }

   // String Representation:
   @Override
   public String toString() {
	   if(location.isEmpty()){
		   return "Name: "+name +"<br/>Email: "+ email +"<br/>Profession: "+profession;
	   }else{
		   return "Name: "+name +"<br/>Email: "+ email +"<br/>Profession: "+profession+ "<br/>Location: "+location;
	   }
      
   }
}