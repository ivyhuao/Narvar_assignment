package contact;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ContactDao {
   // Injected database connection:
   @PersistenceContext
   private EntityManager em;

   // Stores a new contact:
   @Transactional
   public void persist(Contact contact) {
	   em.merge(contact);
   }

   // Retrieves all the contacts:
   public List<Contact> getAllContacts() {
      TypedQuery<Contact> query =
            em.createQuery("SELECT g FROM Contact g ORDER BY g.id", Contact.class);
      return query.getResultList();
   }
}