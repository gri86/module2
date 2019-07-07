package da.db;

import entity.Credential;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.mapping.MetadataSource;

import java.util.List;

public class CredentialDAService {

    public void insert(Credential credential){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(credential);
        session.getTransaction().commit();
        session.close();

    }

    public void get(){
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
        SessionFactory sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();

        Session session = sessionFactory.openSession();

        List<Credential> list = session.createQuery("FROM Credential").getResultList();

        for (Credential credential: list){
            System.out.println(credential.getLogin());
        }

        session.close();
    }




}
