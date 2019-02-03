/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import conexion.AlumnoDao;
import conexion.ProfesorDao;
import java.util.Calendar;
import model.Alumno;
import model.Profesor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Maite
 */
public class App {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        AlumnoDao d = new AlumnoDao();

        //Alta
        Alumno a = new Alumno(17, "Francisco", 20, 'S', Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), Calendar.getInstance().getTime(), "Hola");
        d.altaAlumno(a);
        System.out.println("Dado de alta");

        //Consulta
        Alumno a2 = d.obtenerAlumno(2);
        System.out.println("Código: " + a2.getId());
        System.out.println("Nombre: " + a2.getNombre());

        //Baja
        Alumno a3 = new Alumno();
        a3.setId(16);
        d.bajaAlumno(a3);
        System.out.println("Borrado.");

        ProfesorDao pd = new ProfesorDao();

        //Alta
        Profesor p = new Profesor("Pepe", "Vidal", "Vidal", 2);
        pd.altaProfesor(p);
        System.out.println("Dado de alta");

        //Consulta
        Profesor p2 = pd.obtenerProfesor(1);
        System.out.println("Nombre: " + p2.getNombre());

        //Baja
        Profesor p3 = new Profesor();
        p3.setId(2);
        pd.bajaProfesor(p3);
        System.out.println("Borrado.");
    }

}
