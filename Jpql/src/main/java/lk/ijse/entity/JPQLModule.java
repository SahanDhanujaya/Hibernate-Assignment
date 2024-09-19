package lk.ijse.entity;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lk.ijse.entity.Customer;

import java.util.List;

public class JPQLModule {

    public void insertCustomer(EntityManager entityManager, String name) {
        Customer customer = new Customer();
        customer.setName(name);

        entityManager.getTransaction().begin();
        entityManager.persist(customer);
        entityManager.getTransaction().commit();
    }

    public void deleteCustomer(EntityManager entityManager, int customerId) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("DELETE FROM Customer s WHERE s.id = :cid");
        query.setParameter("cid", customerId);
        int rowsDeleted = query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public void updateCustomer(EntityManager entityManager, int customerId, String newName) {
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("UPDATE Customer c SET c.name = :name WHERE c.no = :cid");
        query.setParameter("name", newName);
        query.setParameter("cid", customerId);
        int rowsUpdated = query.executeUpdate();
        entityManager.getTransaction().commit();
    }

    public List<Customer> searchCustomerByName(EntityManager entityManager, String name) {
        Query query = entityManager.createQuery("SELECT c FROM Customer c WHERE c.name = :name");
        query.setParameter("name", name);
        return query.getResultList();
    }

    public List<Object[]> joinCustomerAddress(EntityManager entityManager) {
        Query query = entityManager.createQuery(
                "SELECT c.id, c.name, a.aId, a.city FROM Customer c JOIN Address a on c.id = a.id"
        );
        return query.getResultList();
    }
}
