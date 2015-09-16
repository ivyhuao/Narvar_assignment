package contact;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ContactController {

   @Autowired
   private ContactDao contactDao;

   @RequestMapping(value = "/contact")
   public ModelAndView contactbook(HttpServletRequest request) {
      // Handle a new contact (if any):
      String name = request.getParameter("name");
      String email = request.getParameter("email");
      String pf = request.getParameter("profession");
      String location = request.getParameter("location");
      
      if (name != null && email!=null && pf!=null)
    	  contactDao.persist(new Contact(name, email, pf,location));

      // Prepare the result view (contact.jsp):
      return new ModelAndView("contact.jsp", "contactDao", contactDao);
   }
}