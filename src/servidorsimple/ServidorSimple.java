
package servidorsimple;
import java.net.*;
import java.io.*;


public class ServidorSimple {

  
    public static void main(String[] args) {
        
      
     
        if(args.length==1){
            if (Metodos.Numerico(args[0])) {
           ServerSocket socketServidor=null;
                try {
                    socketServidor = new ServerSocket(Integer.parseInt(args[0]));
                } catch (IOException ex) {
                   System.out.println("Error al crear el socket" + ex);
                }
                
            while(true){
               try {
                   Socket socket=null;
                   try {
                       socket = socketServidor.accept();
                   } catch (IOException ex) {
                       System.out.println("Error al aceptar conexión" + ex);
                   }
                   BufferedReader lector=null;
                   try {
                       lector = new BufferedReader(
                               new InputStreamReader(socket.getInputStream()) //BR almacenara hasta que encuentre un enter
                       ); } catch (IOException ex) {
                          System.out.println("Error al leer mensaje " + ex);
                       }
                   
                   String mensajeentrada;
                   
                   while((mensajeentrada = lector.readLine()) != null){
                       System.out.println("Mensaje: " + mensajeentrada);
                   }
               } catch (IOException ex) {
                     System.out.println("Error al leer mensaje " + ex);
               }
        }
            
        } else {
            System.out.println("!!Error!!. El puerto debe ser un número");
        }
        }else{
            System.out.println("!!Error!!. Ingresa solamente un argumento (Puerto)");
        }
        
        

        
     
    }
 
}
