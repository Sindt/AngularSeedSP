package facades;

import entity.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class UserFacade {

    EntityManagerFactory emf;

    public UserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public UserFacade() {
    }
    
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    private final Map<String, User> users = new HashMap<>();

    public User getUserByUserId(String id) {
        return users.get(id);
    }
    /*
     Return the Roles if users could be authenticated, otherwise null
     */

    public List<String> authenticateUser(String userName, String password) {
        User user = users.get(userName);
        return user != null && user.getPassword().equals(password) ? user.getRoles() : null;
    }

    public User addUser(User u) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(u);
            em.getTransaction().commit();
            return u;
        } finally {
            em.close();
        }

    }

}
