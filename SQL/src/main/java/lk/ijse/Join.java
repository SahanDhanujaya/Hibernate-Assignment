package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Address;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.List;
import java.util.Objects;

public class Join {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery(" select name,aId from customer c right join address a on c.id = a.customer_id;");
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList){
            System.out.println("Name: "+objects[0] + " ,AddressID: "+objects[1]);
        }

        transaction.commit();
        session.close();

    }
}
