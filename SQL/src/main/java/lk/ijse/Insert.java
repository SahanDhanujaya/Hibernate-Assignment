package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Insert {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("INSERT INTO Customer VALUES (?,?)");
        query.setParameter(1,3);
        query.setParameter(2,"Sahan");
        query.executeUpdate();
        transaction.commit();
        session.close();

    }
}
