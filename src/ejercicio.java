import javax.swing.*;
import java.util.ArrayList;

public class ejercicio {
    static void main(String[] args) {
        ArrayList<String> listaProfesores = new ArrayList<>();
        listaProfesores.add("Cristian");
        listaProfesores.add("Germán");
        listaProfesores.add("Hugo");

        ArrayList<String> listEstudiantes;
        ArrayList<ArrayList<String>> listaGeneralEstudiantes = new ArrayList<>();

        for (int i = 0; i < listaProfesores.size(); i++) {
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes para el profesor " + listaProfesores.get(i));

            // IMPORTANTE: Instanciar una nueva lista en cada iteración del ciclo externo
            listEstudiantes = new ArrayList<String>();

            int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));

            for (int j = 0; j < cant; j++) {
                String nombreEst = JOptionPane.showInputDialog("nombre estudiante " + (j + 1));
                listEstudiantes.add(nombreEst);
            }
            listaGeneralEstudiantes.add(listEstudiantes);
            System.out.print("Profesor " + listaProfesores.get(i) + " = ");
            System.out.println(listEstudiantes);
        }
        System.out.println(listaGeneralEstudiantes);
        ArrayList<String> listaTemporal;
        for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
            listaTemporal = listaGeneralEstudiantes.get(i);
            System.out.print("Profesor: " + listaProfesores.get(i) + " = [");
            for (int j = 0; j < listaTemporal.size(); j++) {
                System.out.print(listaTemporal.get(j) + " ");
            }
            System.out.print("]\n");
        }
    }
}
