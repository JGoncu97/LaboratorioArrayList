package practicaPropia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PracticaEjercicioPropuesto {
    static ArrayList<String> listProfesores;
    static ArrayList<String> listEstudiantes; 
    static ArrayList<ArrayList<String>> listaGeneralEstudiantes;

    public static void main(String[] args) {
        PracticaEjercicioPropuesto iniciar = new PracticaEjercicioPropuesto();
        iniciar.ProfesorEstudiantes();
        int codMenuPpal=0;
		do {
			
			String menu="Menu del sistema\n\n";
			menu+="1. Registrar Profesores \n";
			menu+="2. Registrar Estudiantes\n";
			menu+="3. Lista de Profesores y Estudiantes\n";
			menu+="4. Consulta de Profesor\n";
			menu+="5. Consulta la cantidad de estudiantes de Profesores\n";
			menu+="6. Consulta de Estudiante\n";
			menu+="7. Salir\n\n";
			menu+="Por favor Seleccione una opcion \n";
			codMenuPpal=Integer.parseInt(JOptionPane.showInputDialog(menu));
			
			switch (codMenuPpal) {
			case 1:
				JOptionPane.showMessageDialog(null,"Registrar Profesores" );
					iniciar.RegistrarProfesores();
				break;
			case 2:
				JOptionPane.showMessageDialog(null,"Registrar Estudiantes" );
				if(listProfesores.size() == 0) {
					System.out.println("Debe Ingresar el Registro de profesores primeramente");
				}else {
					iniciar.RegistrarEstudiantes();
				}
				
				break;
			case 3:
				JOptionPane.showMessageDialog(null,"Lista de Profesores y Estudiantes" );
				if(listaGeneralEstudiantes.size()== 0) {
					System.out.println("Debe Ingresar el Registro de Estudiantes primeramente");
				}else {
					
					iniciar.consultarListasProfesoresYEstudiantes();
				}
				
				
				break;
			case 4:
				JOptionPane.showMessageDialog(null,"Consulta de Profesor" );
				if(listProfesores.size() == 0) {
					System.out.println("Debe Ingresar el Registro de profesores primeramente");
				}else {
					iniciar.consultarProfesor();
				}
				
				break;
			case 5:
				JOptionPane.showMessageDialog(null,"Consulta la cantidad de estudiantes de Profesores" );
				if(listProfesores.size() == 0 && listaGeneralEstudiantes.size() == 0 ) {
					System.out.println("Debe Ingresar registros antes de entrar a esta opcion");
				}else if(listProfesores.size()== 0){
					System.out.println("Debe Ingresar el Registro de profesores primeramente");
				}else if(listaGeneralEstudiantes.size()== 0){
					System.out.println("Debe Ingresar el Registro de Estudiantes");
				}else {
					iniciar.consultarEstudiantePorProfesor();
				}
				
				break;
			case 6:
				JOptionPane.showMessageDialog(null,"Consulta de Estudiante" );
				if(listaGeneralEstudiantes.size() == 0) {
					System.out.println("Debe Ingresar el Registro de Estudiantes primeramente");
				}else {
					iniciar.consultarEstudiante();
				}
				 
				break;
			case 7:
				JOptionPane.showMessageDialog(null,"Salida del sistema" );
				break;
			
			default:
				JOptionPane.showMessageDialog(null,"No corresponde a un"
						+ "codigo valido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE );
				break;
					
			}
		}while(codMenuPpal !=7);
		
        
       
    }

    public void ProfesorEstudiantes() {
        listProfesores = new ArrayList<>();
        listEstudiantes = new ArrayList<>();
        listaGeneralEstudiantes = new ArrayList<>();
    }

    private void RegistrarProfesores() {
        int contador = 0;
        String profesor = "";
        System.out.println("\n<<<Registro de Profesores>>>\n");

        contador = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos Profesores desea registrar?"));

        for (int i = 0; i < contador; i++) {
            profesor = JOptionPane.showInputDialog("Ingrese el nombre del profesor " + (i + 1));
        	if(!listProfesores.contains(profesor)) {
        		listProfesores.add(profesor);
			}else{
				
				System.out.println("El profesor ya existe en el registro");
				i--;
				continue;
			}
  
        }

        System.out.println("Registro de profesores exitoso!!\n");
    }

    private void RegistrarEstudiantes() {
        System.out.println("\n<<<Registro de Estudiantes>>>\n");
        for (int i = 0; i < listProfesores.size(); i++) {
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes para "
            		+ "el profesor " + listProfesores.get(i));
            
            listEstudiantes=new ArrayList<String>();

            int contador = Integer.parseInt(JOptionPane.showInputDialog("¿Cuántos estudiantes desea "
            		+ "registrar?"));
           

            for (int x = 0; x < contador; x++) {
                String estudiante = JOptionPane.showInputDialog("Ingrese el nombre del estudiante " + (x + 1));
                
                if(!listEstudiantes.contains(estudiante)) {
                	listEstudiantes.add(estudiante);
    			}else{
    				
    				System.out.println("El estudiante ya existe en el registro");
    				x--;
    				continue;
    			}
                
            }

            listaGeneralEstudiantes.add(listEstudiantes); 
        }
        System.out.println("Registro de estudiantes exitoso!!");
    }

    private void consultarListasProfesoresYEstudiantes() {
        System.out.println("\n<<<Lista de Profesores y Estudiantes>>>\n");
        ArrayList <String> listaTemporal;
        for (int i = 0; i < listaGeneralEstudiantes.size(); i++) {
        	
        	listaTemporal=listaGeneralEstudiantes.get(i);
        	System.out.print("Profesor: "+listProfesores.get(i)+" =");
        	System.out.print("[");
        	for(int x=0;x<listaTemporal.size();x++) {
        		System.out.print(listaTemporal.get(x));
        		if(x<listaTemporal.size()-1) {
        			System.out.print(",");
        		}
        		
        	}
        	System.out.print("]\n");
        }
    }
    
    private void consultarProfesor() {
    	System.out.print("\n<<<Consulta de Profesor >>>");
    	String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor a consultar");
    	
    	
    		
    		if(listProfesores.contains(nombre)) {
    			int posicion=listProfesores.indexOf(nombre);
    			ArrayList <String> listaEstudiantesTemporal=listaGeneralEstudiantes.get(posicion);
    			
    			System.out.print("\nProfesor: "+nombre+ " = ");
    			System.out.print("[");
    			for(int i=0;i<listaEstudiantesTemporal.size();i++) {
    				System.out.print(listaEstudiantesTemporal.get(i));
    				
    				if(i<listaEstudiantesTemporal.size()-1) {
    					System.out.println(",");
    					
    				}
    				
    			}
    			System.out.print("]\n");
    		}else {
    			System.out.println("No se encuentra el profesor "+nombre);
    		}
    		
    	}
    
    private void consultarEstudiantePorProfesor() {
    	System.out.print("\n<<< Consulta  cantidad de estudiantes  de profesores >>> \n");
    	String nombre=JOptionPane.showInputDialog("Ingrese el nombre del profesor para saber"
    			+ " la cantidad de estudiantes asociados");
    	
    	if(listProfesores.contains(nombre)) {
    		int posicion=listProfesores.indexOf(nombre);
    		ArrayList<String> listaEstudiantesTemporal= listaGeneralEstudiantes.get(posicion);
    		System.out.println("La cantidad de estudiantes asociados al profesor "+nombre+""
    				+ " es "+listaEstudiantesTemporal.size());
    	}else {
    		System.out.println("No se encuentra el profesor "+nombre+ "\n");
    	}
    	
    }
    
    private void consultarEstudiante() {
    	System.out.print("\n<<<Consulta de Estudiante >>>\n");
    	ArrayList<String> listaTemporal;
    	
    	String nombre=JOptionPane.showInputDialog("Ingrese el nombre del estudiante a consultar");
    	
    	for(int i=0;i<listaGeneralEstudiantes.size();i++) {
    		
    		listaTemporal=listaGeneralEstudiantes.get(i);
    		
    		if(listaTemporal.contains(nombre)) {
    			for(int x=0;x<listaTemporal.size();x++) {
    				
    				if(listaTemporal.get(x).equalsIgnoreCase(nombre)) {
    					System.out.println("Encuentra al nombre: "+nombre+" pertenece al "
    							+ "grupo de "+listProfesores.get(i));
    					
    				}
    				
    			}
    			
    		}else {
    			System.out.println("No se encuentra el nombre en el grupo de "+listProfesores.get(i));
    		}
    		
    	}
    }
    
    
    
}
