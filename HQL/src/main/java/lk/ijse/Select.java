package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import lk.ijse.entity.Customer;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Select {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query=session.createQuery("select id,name from Customer where id=?1");
        query.setParameter(1,1);
        List<Object[]> resultList = query.getResultList();
        for (Object[] objects : resultList){
            System.out.println("ID :"+objects[0] + "Name :"+objects[1]);
        }

        Query query1=session.createQuery("select id,name from Customer");
        List<Object[]> resultList1 = query1.getResultList();
        for (Object[] objects : resultList1){
            System.out.println("ID: "+objects[0]+"Name: "+objects[1]);
        }

        Query query2=session.createQuery("select a.aId,c.name from Address a inner join Customer c on a.aId = c.id");
        List<Object[]> resultList2 = query2.getResultList();
        for (Object[] objects : resultList2){
            System.out.println("AddressID: "+objects[0]+"Name: "+objects[1]);
        }
        transaction.commit();
        session.close();
    }
}
