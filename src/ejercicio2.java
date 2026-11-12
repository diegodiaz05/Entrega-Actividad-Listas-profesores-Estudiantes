import javax.swing.*;
import java.util.ArrayList;
public class ejercicio2 {
    ArrayList<String> listaProfesores;
    ArrayList<String> listEstudiantes;
    ArrayList<ArrayList<String>> listaGeneralEstudiantes;
    public ejercicio2() {
        listaProfesores = new ArrayList<>();
        listaGeneralEstudiantes = new ArrayList<>();
    }
    public void iniciar() {
        int opcion = 0;
        do {
            String menu = "--- MENÚ PRINCIPAL --- \n";
            menu+="1. Registrar Profesores\n";
            menu+="2. Registrar Estudiantes\n";
            menu+="3. Consultar Lista Completa: Profesores y Estudiantes\n";
            menu+="4. Consultar Profesor por Nombre\n";
            menu+="5. Consultar Cantidad de Estudiantes por Profesor\n";
            menu+="6. Consultar a qué Grupo Pertenece un Estudiante\n";
            menu+="7. Salir\n\n";
            menu+="Ingrese una opción:";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (opcion) {
                case 1:
                    registrarProfesores();
                    break;
                case 2:
                    if (listaProfesores.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "¡Error! Primero debe registrar profesores antes de agregar estudiantes.");
                    } else {
                        registrarEstudiantes();
                    }
                    break;
                case 3:
                    if (listaProfesores.isEmpty() || listaGeneralEstudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null,  "Primero debe registrar profesores y estudiantes.", "ERROR",JOptionPane.ERROR_MESSAGE);
                    } else {
                        consultarListaProfesoresYEstudiantes();
                    }
                    break;
                case 4:
                    if (listaProfesores.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "¡Error! No hay profesores registrados en el sistema.","ERROR",JOptionPane.ERROR_MESSAGE);
                    } else {
                        consultaProfesorPorNombre();
                    }
                    break;
                case 5:
                    if (listaProfesores.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "¡Error! No hay profesores registrados.","ERROR",JOptionPane.ERROR_MESSAGE);
                    } else {
                        consultaCantidadEstudiantesPorProfesor();
                    }
                    break;
                case 6:
                    if (listaGeneralEstudiantes.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "¡Error! Primero debe registrar estudiantes.","ERROR",JOptionPane.ERROR_MESSAGE);
                    } else {
                        consultarEstudiante();
                    }
                    break;
                case 7:
                    JOptionPane.showMessageDialog(null, "Saliendo del sistema...","ADVERTENCIA",JOptionPane.WARNING_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 7);
    }
    private void registrarProfesores() {
        System.out.println("\n--- Registro de Profesores ---");
        int cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Cantidad de profesores"));

        for (int i = 0; i < cant; i++) {
            String nombreProfesor = JOptionPane.showInputDialog("nombre Profesor " + (i + 1));
            if (listaProfesores.contains(nombreProfesor)) {
                JOptionPane.showMessageDialog(null, "El profesor '" + nombreProfesor + "' ya está registrado.");
                i--;
            } else {
                listaProfesores.add(nombreProfesor);
            }
        }
        System.out.println("Registro de profesores Exitoso!\n");
        JOptionPane.showMessageDialog(null, "¡Registro de profesores exitoso!");
    }
    private void registrarEstudiantes() {
        System.out.println("\n--- Registro de Estudiantes ---");
        listaGeneralEstudiantes.clear();
        for (int i = 0; i < listaProfesores.size(); i++) {
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes para el profesor " + listaProfesores.get(i));
            listEstudiantes = new ArrayList<String>();
            int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de estudiantes"));
            for (int j = 0; j < cant; j++) {
                String nombreEst = JOptionPane.showInputDialog("nombre estudiante " + (j + 1));
                if (listEstudiantes.contains(nombreEst)) {
                    JOptionPane.showMessageDialog(null, "El estudiante '" + nombreEst + "' ya se encuentra en este grupo.");
                    j--;
                } else {
                    listEstudiantes.add(nombreEst);
                }
            }
            listaGeneralEstudiantes.add(listEstudiantes);
        }
        System.out.println("Registro de estudiantes Exitoso!\n");
        JOptionPane.showMessageDialog(null, "¡Registro de estudiantes exitoso!");
    }
    private void consultarListaProfesoresYEstudiantes() {
        System.out.println("\n--- Lista de Profesores y Estudiantes ---");
        ArrayList<String> listaTemporal;
        for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
            listaTemporal = listaGeneralEstudiantes.get(i);
            System.out.print("Profesor: " + listaProfesores.get(i) + " = ");
            System.out.print("[");
            for (int j = 0; j < listaTemporal.size(); j++) {
                System.out.print(listaTemporal.get(j));
                if (j < listaTemporal.size() - 1) {
                    System.out.print(",");
                }
            }
            System.out.print("]\n");
        }
        JOptionPane.showMessageDialog(null, "Consulta realizada. Revise la consola.");
    }
    private void consultaProfesorPorNombre() {
        System.out.println("\n--- Consulta de Profesor --- \n");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del profesor");
        if (listaProfesores.contains(nombre)) {
            int posicion = listaProfesores.indexOf(nombre);
            ArrayList<String> listaEstudiantesTemporal = listaGeneralEstudiantes.get(posicion);

            String resultado = "Profesor: " + nombre + " = " + listaEstudiantesTemporal.toString();
            System.out.println(resultado);
            JOptionPane.showMessageDialog(null, resultado);
        } else {
            System.out.println("No se encuentra el profesor " + nombre + "\n");
            JOptionPane.showMessageDialog(null, "No se encuentra el profesor " + nombre);
        }
    }
    private void consultaCantidadEstudiantesPorProfesor() {
        System.out.println("\n--- Consulta cantidad de estudiantes de Profesores --- \n");
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber la cantidad de estudiantes asociados");

        if (listaProfesores.contains(nombre)) {
            int posicion = listaProfesores.indexOf(nombre);
            ArrayList<String> listaEstudiantesTemporal = listaGeneralEstudiantes.get(posicion);
            String mensaje = "La cantidad de estudiantes asociados al profesor " + nombre + " es " + listaEstudiantesTemporal.size();
            System.out.println(mensaje);
            JOptionPane.showMessageDialog(null, mensaje);
        } else {
            System.out.println("No se encuentra el profesor " + nombre + "\n");
            JOptionPane.showMessageDialog(null, "No se encuentra el profesor " + nombre);
        }
    }
    private void consultarEstudiante() {
        System.out.println("\n--- Consulta de Estudiante --- \n");
        ArrayList<String> listTemporal;
        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");
        boolean encontrado = false;
        for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
            listTemporal = listaGeneralEstudiantes.get(i);
            if (listTemporal.contains(nombre)) {
                String mensaje = "El estudiante " + nombre + " pertenece al grupo de " + listaProfesores.get(i);
                System.out.println(mensaje);
                JOptionPane.showMessageDialog(null, mensaje);
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            String mensaje = "No se encuentra el estudiante " + nombre + " en ningún grupo.";
            System.out.println(mensaje);
            JOptionPane.showMessageDialog(null, mensaje);
        }
    }
}