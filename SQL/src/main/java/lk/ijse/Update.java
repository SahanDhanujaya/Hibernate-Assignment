package lk.ijse;

import lk.ijse.config.FactoryConfiguration;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.NativeQuery;

public class Update {
    public static void main(String[] args) {
        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        NativeQuery query = session.createNativeQuery("UPDATE Customer SET name = ? WHERE id = ? ");
        query.setParameter(1,"Dhanujaya");
        query.setParameter(2,2);
        query.executeUpdate();
        transaction.commit();
        session.close();

    }
}
