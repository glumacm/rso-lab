package si.fri.rso.uberapp.users.api;

import javax.enterprise.context.RequestScoped;
import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@RequestScoped
public class UserService {

    @PersistenceContext
    private EntityManager em;


    public User getUser(String userId){
        return em.find(User.class, userId);
    }
    public List<User> getUsers(){
        List<User> users = em.createNamedQuery("User.findUsers", User.class)
                .getResultList();
        return users;
    }

    @Transactional
    public void saveUser(User user){
        if(user != null){
            em.persist(user);
        }
    }

    @Transactional(Transactional.TxType.REQUIRED)
    public void delelteUser(String userId){
        User user = em.find(User.class, userId);
        if(user != null){
            em.remove(user);
        }
    }
}
