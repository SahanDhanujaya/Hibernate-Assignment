package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

public class update {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("update Customer set name = ?1 where id= ?2");
        query.setParameter(1,"DhanuEkanayake");
        query.setParameter(2,2);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }
}
