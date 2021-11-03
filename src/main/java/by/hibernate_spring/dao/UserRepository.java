package by.hibernate_spring.dao;

import by.hibernate_spring.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user){
        Session current = sessionFactory.getCurrentSession();
        current.save(user);
    }

    public boolean contains(String username){
        Session currentSession = sessionFactory.getCurrentSession();
        Long singleResult = currentSession
                .createQuery("select count(*) from User as u where u.username = :username", Long.class)
                .setParameter("username",username)
                .getSingleResult();
        return singleResult > 0;
    }
}
