package ru.web.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.web.model.Product;

import java.util.List;

@Repository
public class ProductRepository {

  @Autowired
  private SessionFactory sessionFactory;

  public void saveProduct(Product product) {
    Session session = sessionFactory.getCurrentSession();
    session.save(product);
  }

  public List<Product> getAllProducts() {
    Session session = sessionFactory.getCurrentSession();
    Query<Product> query = session.createQuery("from Product");
    return query.getResultList();
  }
}
