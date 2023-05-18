package ru.web.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.web.model.User;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.save(user);
    }

    public User findByEmail(String email) {
        Session session = sessionFactory.getCurrentSession();
        Query<User> query = session.createQuery("from User WHERE email = :email");
        query.setParameter("email", email);
        return query.uniqueResult();
    }
}
