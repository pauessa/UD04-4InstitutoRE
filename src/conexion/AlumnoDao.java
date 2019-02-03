/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexion;

import model.Alumno;
import org.hibernate.Session;

/**
 *
 * @author Pauessa
 */
public class AlumnoDao {
    // Consulta alumno

    public AlumnoDao() {
    }

    public Alumno obtenerAlumno(int id) {
        Session s = NewHibernateUtil.getCurrentSession();
        s.beginTransaction();
        Alumno result = (Alumno) s.get(Alumno.class, id);
        s.getTransaction().commit();
        s.close();
        return result;
    }

    public void altaAlumno(Alumno a) {
        Session s = NewHibernateUtil.getCurrentSession();
        s.beginTransaction();
        s.save(a);
        s.getTransaction().commit();
        s.close();
    }

    public void bajaAlumno(Alumno a) {
        Session s = NewHibernateUtil.getCurrentSession();
        s.beginTransaction();
        s.delete(a);
        s.getTransaction().commit();
        s.close();
    }

}
