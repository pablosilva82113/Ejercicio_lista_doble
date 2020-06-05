import java.io.*;
import java.util.Random;

public class Suerte {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		InputStreamReader r= new InputStreamReader(System.in);
		BufferedReader Teclado=new BufferedReader(r);
		ListaDobleEnlazada L = new ListaDobleEnlazada();
		Random Moneda=new Random();
		int Num;
		String resp="";
		System.out.println("Bienvenido vamos a guardar numeros enteros");
		for (int i = 0; i < 5; i++) {
			System.out.println("Dame un numero");
			Num=Integer.parseInt(Teclado.readLine());
			L.agregarAlInicio(new Nodo <Integer>(Num,1));
		}
		do{
			System.out.println("Deseas continuar S/N");
			resp=Teclado.readLine();
			if(resp.compareToIgnoreCase("S")==0) {
			System.out.println("Dame un numero");
			Num=Integer.parseInt(Teclado.readLine());
			L.agregarAlInicio(new Nodo <Integer>(Num,1));
			}
		}while(resp.compareToIgnoreCase("S")==0);
		//mostrando los elementos
		System.out.println("Tus numeros son");
		System.out.println(L.toStringRevers());
		System.out.println(L);
		int c=0;
	
			//////eliminar 
				int b =L.obtenerNoElementos()-1;
				for(int i=0;i<b;i++) {
				boolean mon=Moneda.nextBoolean();
				if(mon==true) {//cara
					L.eliminarAlInicio();
				}else if(mon==false) {//cruz
					L.eliminarAlFin();
				}
				c++;
				}
				
		System.out.println("La moneda se lanzo "+c);
		System.out.println("Tu numero de la suerte es "+L);
	}

}
