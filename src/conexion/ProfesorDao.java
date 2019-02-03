/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import model.Alumno;
import model.Profesor;
import org.hibernate.Session;

/**
 *
 * @author Pauessa
 */
public class ProfesorDao {
    // Consulta alumno

    public ProfesorDao() {
    }

    public Profesor obtenerProfesor(int id) {
        Session s = NewHibernateUtil.getCurrentSession();
        s.beginTransaction();
        Profesor result = (Profesor) s.get(Profesor.class, id);
        s.getTransaction().commit();
        s.close();
        return result;
    }

    public void altaProfesor(Profesor p) {
        Session s = NewHibernateUtil.getCurrentSession();
        s.beginTransaction();
        s.save(p);
        s.getTransaction().commit();
        s.close();
    }

    public void bajaProfesor(Profesor p) {
        Session s = NewHibernateUtil.getCurrentSession();
        s.beginTransaction();
        s.delete(p);
        s.getTransaction().commit();
        s.close();
    }

}
