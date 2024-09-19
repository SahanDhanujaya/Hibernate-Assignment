package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;
import java.util.List;

public class Select {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("SELECT * FROM Customer WHERE name = ?");
        query.setParameter(1,"Dhanu");
        query.addEntity(Customer.class);
        List<Customer> list = query.list();
        for (Customer customer : list){
            System.out.println(customer.getName());
        }
        transaction.commit();
        session.close();

    }
}