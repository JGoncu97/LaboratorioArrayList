package practicaPropia;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class PracticaEjercicioPropuesto {
	
	//Creamos fuera del main, la lista de arreglos para porder llamarla en 
	//todas las instancias del codigo.
    static ArrayList<String> listProfesores;
    static ArrayList<String> listEstudiantes; 
    static ArrayList<ArrayList<String>> listaGeneralEstudiantes;
    //Observacio: cuando llame las listas al meno realice en el main , el programa 
    //me pedia colocar las listas como Static para no tener conflicto dentro del do while
    //Antes de colocarlos en el menu no pedia este requerimiento
    public static void main(String[] args) {
    	/*Declaramos una objeto  de la clase , para que poder interactuar con los metodos en el main*/
        PracticaEjercicioPropuesto iniciar = new PracticaEjercicioPropuesto();
        /*usamos el objeto con el metodo para iniciar el primer metodo*/
        iniciar.ProfesorEstudiantes();
        /*Declaramos una variable inicializada en 0, esta variable la utilizaremos para trabajar en el menu 
         * que crearemos con un stwich case */
        int codMenuPpal=0;
        /*Utilizamos un do while para que el lea el contenido de la opciones del menu y dependiendo de la
         * del dato ingresado entre en el caso o salga del sistema, le colocamos en un ciclo
         * para que se repita como tantas veces desee el usuario y que la unica manera de pararlo sea por
         * la misma decision del usuario al ingresar la opcion para salir*/
		do {
			/*declaracion de variable menu para darle la estructura del menu  que queremos hacer , 
			utilizamos \n para hacer un salto de linea hace le damos mas estilo al menu*/
			String menu="Menu del sistema\n\n";
			menu+="1. Registrar Profesores \n";
			menu+="2. Registrar Estudiantes\n";
			menu+="3. Lista de Profesores y Estudiantes\n";
			menu+="4. Consulta de Profesor\n";
			menu+="5. Consulta la cantidad de estudiantes de Profesores\n";
			menu+="6. Consulta de Estudiante\n";
			menu+="7. Salir\n\n";
			menu+="Por favor Seleccione una opcion \n";
			/*utilizamos la variable que declaramos en 0, utilizamores un Input con JOptionPane,
			 * y colocamos la variable menu dentro, al realizar eso cuando el sistema lea la linea de codigo
			 * nos mostrara el menu que realizamos y directamente solicitara un dato al usuario mientras visualiza el menu*/
			codMenuPpal=Integer.parseInt(JOptionPane.showInputDialog(menu));
			/*Utilizamos un switch case para poder dividir las opciones del menu , dependiendo de la 
			 * opcion escojida por el usuario el switch verificara la existencia de dato recojido 
			 * y lo compara con los casos hasta encontrar el caso correcto, en caso de que 
			 * el dato recorrido no coincida con los caso, envie una alerta indicando la respuesta 
			 * del usuario no coincide con las opciones del menu*/
			switch (codMenuPpal) {
			case 1:
				/*Caso 1 registra los nombre de los profesores*/
				JOptionPane.showMessageDialog(null,"Registrar Profesores" );
					iniciar.RegistrarProfesores();
				break;
			case 2:
				/*Caso 2 registra los estudiantes
				 * pero tiene una condicion deben existir datos en la lista del caso 1 para poder
				 * seguir su funcionamiento, de lo contrario envia un mensaje donde indica que se debe registrar profesores primero
				 * y seguido regresa el usuario al menu*/
				JOptionPane.showMessageDialog(null,"Registrar Estudiantes" );
				if(listProfesores.size() == 0) {
					System.err.println("Debe Ingresar el Registro de profesores primeramente");
				}else {
					iniciar.RegistrarEstudiantes();
				}
				
				break;
			case 3:
				/*el caso 3 es consultar la lista de profesores y estudiante
				 * pero tambien le indicamos una condicion que la lista general de estudiante, debe contener 
				 * datos internos de lo contrario dara un mensaje indicandole al usuario que debe registrar estudiantes 
				 * antes de aplicar esta opcion*/
				JOptionPane.showMessageDialog(null,"Lista de Profesores y Estudiantes" );
				if(listaGeneralEstudiantes.size()== 0) {
					System.err.println("Debe Ingresar el Registro de Estudiantes primeramente");
				}else {
					
					iniciar.consultarListasProfesoresYEstudiantes();
				}
				
				
				break;
			case 4:
				/*el caso 4 es para consultar el registro de profesor  y estudiantes , el nos arroja como resultado
				 * el nombre del profesor y los estudiantes que pertenecen a dicho profesor, pero 
				 * colocamos una condicion que debe tener registro en la lista de profesor para iniciar , de lo 
				 * contrario envie un mensaje que indique que se debe registrar antes de entrar a esta opcion*/
				JOptionPane.showMessageDialog(null,"Consulta de Profesor" );
				if(listProfesores.size() == 0) {
					System.err.println("Debe Ingresar el Registro de profesores primeramente");
				}else {
					iniciar.consultarProfesor();
				}
				
				break;
			case 5:
				/*el caso 5 es para consultar la cantida de estudiantes asignados a un profesor, 
				 * pero le colocamos una condicion que solicite que en general estudiante y profesor tengas datos  si 
				 * esta condicion es falta le de un error al usuario que indique  que debe realizar los registros de
				 * profesor o estudiante, fuera de eso para aun pulir mas de errores colocamos dos condicions que aun si tiene
				 * registros en profesores , pero no en estudiantes no permita su ingreso al metodo, si o si debe tener registros en ambas opciones*/
				JOptionPane.showMessageDialog(null,"Consulta la cantidad de estudiantes de Profesores" );
				if(listProfesores.size() == 0 && listaGeneralEstudiantes.size() == 0 ) {
					System.err.println("Debe Ingresar registros antes de entrar a esta opcion");
				}else if(listProfesores.size()== 0){
					System.err.println("Debe Ingresar el Registro de profesores primeramente");
				}else if(listaGeneralEstudiantes.size()== 0){
					System.err.println("Debe Ingresar el Registro de Estudiantes");
				}else {
					iniciar.consultarEstudiantePorProfesor();
				}
				
				break;
			case 6:
				/*el caso 6 es para consultar los estudiantes existente en el registro, pero tiene una condicion
				 * si en la lista de estudiantes no existe registro al alguno de al menos 1 estudiante, no realiace esta accion
				 * y envie un mensaje indicando la necesidad de registros de estudiantes*/
				JOptionPane.showMessageDialog(null,"Consulta de Estudiante" );
				if(listaGeneralEstudiantes.size() == 0) {
					System.err.println("Debe Ingresar el Registro de Estudiantes primeramente");
				}else {
					iniciar.consultarEstudiante();
				}
				 
				break;
			case 7:
				/*esta opcion es para darle sali del sistema*/
				JOptionPane.showMessageDialog(null,"Salida del sistema" );
				break;
			
			default:
				/*la opcion por defecto nos indica que si el numero ingresado por el usuario no corresponde
				 * a las opciones del menu envie esta alerta indicando que no corresponde 
				 * su respuesta con las opciones del menu*/
				JOptionPane.showMessageDialog(null,"No corresponde a un "
						+ "codigo valido","ADVERTENCIA",JOptionPane.WARNING_MESSAGE );
				break;
					
			}
			/*En el while nuestra condicion nos indica que si los numeros ingresado por la 
			 * variable codMenuPal son diferentes de 7 que siga repitiendo el ciclo, si la 
			 * condicion se cumple entonces culmine el ciclo y el sistema se cierra*/
		}while(codMenuPpal !=7);
		
        
       
    }
/*El metodo ProfesorEstudiante lo utilizamos para inicializar las 3 listas que utilizaremos 
 * para almacenar la informacion en los metodos privados, por eso es que se crea este metodo publico
 * para que pueda ser visible a todos los demas codigo
 * */
    public void ProfesorEstudiantes() {
        listProfesores = new ArrayList<>();
        listEstudiantes = new ArrayList<>();
        listaGeneralEstudiantes = new ArrayList<>();
    }

    /*En el metodo privado RegistrarProfesores  lo utilizamos para realizar la operacion
     * del registro de informacion de los profesores, como se puede ver declaramos una variable llamado
     * contador que sera nuestro punto de referencia a utilizar en un ciclo, para que al usuario ingresar cuantos 
     * profesores desea registrar, el tome esa variable como maximo para el ciclo llegar, internamente en el 
     * ciclo preguntaremos el nombre del profesor a registrar 
     *  pero tambien colocaremos una condicional que nos pregunte que si(el nombre que estamos registrando
     *  no se encuentra en la lista entonces entre y agrege a la lista) de lo contrario que nos imprima un mensaje
     *  que nos indica que el registro existe, que reste -1 el punto i y continue para que asi repita el ciclo en la misma posicion
     *  hasta que reciba un dato no existente, para almacenarlo en la lista*/
    
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
/*En este metodo hacemos el registro de los estudiantes, en donde utilizamos un ciclo que tome la lista de profesores.size
 * como indicativo para el ciclo ya que recorre las posiciones segun la cantida de profesores, y asi enviar un mensaje que indique 
 * que registremos datos  para 1 profesor en especifico, asi nos aseguramos de registrar estudiantes para cada profesor y  se encuentren
 * asociados entre si, tambien utilizamos una variable dentro del primer ciclo */
    private void RegistrarEstudiantes() {
        System.out.println("\n<<<Registro de Estudiantes>>>\n");
        for (int i = 0; i < listProfesores.size(); i++) {
            JOptionPane.showMessageDialog(null, "Ingrese los estudiantes para "
            		+ "el profesor " + listProfesores.get(i));
            
            

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
