package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

import java.util.Arrays;
import java.util.List;

public class Select {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("SELECT * FROM Customer WHERE name = ?");
        query.setParameter(1,"Dhanu");
        List<Object[]> resultList = query.getResultList();
        for (Object[] customer : resultList){
            System.out.println(Arrays.toString(customer));
        }
        transaction.commit();
        session.close();

    }
}