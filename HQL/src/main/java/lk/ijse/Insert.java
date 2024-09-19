package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class Insert {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("insert into Customer(id,name) values (?1,?2)");
        query.setParameter(1,3);
        query.setParameter(2,"Sahan");
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}