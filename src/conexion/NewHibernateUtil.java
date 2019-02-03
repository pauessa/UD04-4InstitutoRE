/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author Pauessa
 */
public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final ThreadLocal session=new ThreadLocal();
    static {
        try {
            
            Configuration config =new Configuration().configure();
            sessionFactory = config.buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static Session getCurrentSession(){
        Session s=(Session)session.get();
        if(s==null||!s.isOpen()){
            s=sessionFactory.openSession();
        }
        session.set(s);
        return s;
    }
    public static void CloseSession(){
        Session s =(Session) session.get();
        if(s!=null||s.isOpen()){
            s.close();
        }
        session.set(s);
    }
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
