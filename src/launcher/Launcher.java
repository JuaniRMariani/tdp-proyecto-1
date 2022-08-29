package launcher;

import entities.Student;
import gui.SimplePresentationScreen;
import javax.swing.JFrame;

public class Launcher {
	public static void main(String [] args) {
		Student estudiante = new Student(122567, "Rodriguez Mariani", "Juan Ignacio", "juanirmariani@gmail.com",
		"https://github.com/JuaniRMariani",
		"C:\\Users\\U\\OneDrive\\Escritorio\\Estudios\\Carrera Ing. Sistemas\\Tecnología de Programación\\Proyectos TDP\\Primer Proyecto\\proyecto-1\\src\\images\\foto.jpg");		
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              JFrame ejecutar = new SimplePresentationScreen(estudiante);
              ejecutar.setVisible(true);
            }
        }
        );
    }
}