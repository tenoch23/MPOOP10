import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.StringTokenizer;

class Main {
  public static void main(String[] args) {
    System.out.println("##########File#########");
    File archivo = new File("Archivo.txt");
    System.out.println(archivo.exists()); //Aun no existe el archivo

    if(!archivo.exists()){ //Aqui detecta si el archivo no existe
      try
      {
        boolean seCreo = archivo.createNewFile(); //Este metodo lanza una excepcion
        System.out.println(seCreo);
        System.out.println(archivo.exists());
      }catch(IOException e){ //Necesitamos importar java.io.IOException
        System.out.println(e.getMessage());
      }

    }

  System.out.println("#########FileWriter########");
  try
  {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); /*Necesitamos imporat java.io.InputStreamReader y java.io.BufferedReader 
    Con esta linea creamos un canal para poder leer información desde el teclado*/
  System.out.println("Escriba texto para el archivo");
  String texto = br.readLine(); // leemos texto del teclado
  String texto2 = "Hola mundo";
  FileWriter fw = new FileWriter("fw.csv"); //creamos archivo excel
  BufferedWriter bw = new BufferedWriter(fw); //java.io.BufferedWriter con esto apuntamos al archivo
  PrintWriter salida = new PrintWriter(bw); //java.io.PrintWriter con esto indicamos la cadena de texto en el archivo
  salida.println(texto);//Aqui se imprime el texto en el archivo
  salida.println(texto2);

  for (int i=0;i<10;i++)
    salida.println("Linea "+i+" del for");

  String[] arrayCadena = {"a","e","i","o","u"};
  for (int i=0;i<arrayCadena.length;i++)
    salida.println(arrayCadena[i]);

  for(int i=0;i<10;i++)
    salida.println("Antonio,Ayala,Barbosa,3183020,23,45");

  


  salida.close();
  }catch(IOException e){ //Todos estos metodos nos lanzan una excepcion
        System.out.println(e.getMessage());
      }

System.out.println("########FileReader#######");
try{
  FileReader fr = new FileReader("fw.csv");
BufferedReader br = new BufferedReader(fr);
String linea = br.readLine(); // Con este vemos si la linea tiene o no informacion
while (linea!=null){
  System.out.println(linea);
  linea=br.readLine();
}
}catch(FileNotFoundException ex){
  System.out.println(ex.getMessage());
}catch(IOException ex ){ 
        System.out.println(ex.getMessage());
      }
System.out.println("#######StringTokenizer######");

  String linea = "Antonio,Ayala,Barbosa,3183020,23,45";

  StringTokenizer tokenizador = new StringTokenizer(linea,",");
  int count = 0;
  String nombre=null,apPaterno=null,apMaterno=null;
  int numCuenta=0,edad=0; 
  float creditos=0;
  while(tokenizador.hasMoreTokens()){
    String aux = tokenizador.nextToken();
    System.out.println(aux);
    if(count==0)
      nombre = aux;
    else if(count==1)
      apPaterno = aux;
      else if(count==2)
        apMaterno=aux;
        else if(count==3)
          numCuenta=Integer.parseInt(aux);
            else if(count==4)
              edad= Integer.parseInt(aux);
                else if(count==5)
                  creditos = Float.parseFloat(aux);
      count++;
   }
       System.out.println("El alumno es:");
    System.out.println(nombre+","+apPaterno+","+apMaterno+","+numCuenta+","+edad+","+creditos);
    count=0;
  }
}