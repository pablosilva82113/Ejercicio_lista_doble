
public class ListaDobleEnlazada {
	//Referencia al inicio
			private Nodo Inicio;
			//Referencia al fin
			private Nodo Fin;
			private int NoElementos;
			public ListaDobleEnlazada () {
				Inicio=null;
				Fin=null;
				 NoElementos=0;
			}
			public int obtenerNoElementos() {
				return  NoElementos;
			}
			public void agregarAlInicio(Nodo AG) {
				//caso cunado no tengo nodos
				if(Inicio==null) {
					Inicio=AG;
					Fin=AG;
					 NoElementos++;
				}else {//mi lista almenos tiene un nodo
					AG.Siguiente=Inicio;
					Inicio.Anterior=AG;
					Inicio=AG;
					 NoElementos++;
				}
			}
			public void agregarAlFin(Nodo AG) {
				//caso cunado no tengo nodos
				if(Fin==null) {
					Fin=AG;
					Inicio=AG;
					NoElementos++;
				}else {//mi lista almenos tiene un nodo
					Fin.Siguiente=AG;
					AG.Anterior=Fin;
					Fin=AG;
					NoElementos++;
				}
			}
			
			public boolean buscar(Nodo AB) {
				if(AB!=null) {
					if(Inicio !=null) {
						if(Inicio.obtenerData()==AB.obtenerData()) {
							return true;
						}
					}
					if(Fin !=null) {
						if(Fin.obtenerData()==AB.obtenerData()) {
							return true;
						}
					}
					//Si el elemento abuscar no esta en el inicio ni en el fin
					Nodo ref=Inicio;
					boolean Encontrado=false;
					while ((ref!=null)&&!Encontrado) {
						//Si esto es cierto el nodo ya fue encontrado
						if(ref.obtenerData()==AB.obtenerData()) {
							Encontrado=true;
						}
						ref=ref.Siguiente;
					}
					return Encontrado;
				}
				return false;
			}
			
			public Nodo eliminarAlInicio() {
				if(Inicio==null) {
					return null;
				}else {
				Nodo ret=Inicio;
				Inicio=Inicio.Siguiente;
				Inicio.Anterior=null;
				
				ret.Siguiente=null;
				ret.Anterior=null;
				 NoElementos--;
				 return ret;
				}
			}
			
			public Nodo eliminarAlFin() {
				if(Fin==null) {
					return null;
				}else {
				
				 Nodo eliminar = Fin;
				 Fin=Fin.Anterior;
				 Fin.Siguiente=null;
				 
				 eliminar.Siguiente=null;
				 eliminar.Anterior=null;
				 NoElementos--;
				return eliminar;
				}
			}
			
			public Nodo eliminarPorNodo(Nodo AB) {
				if(AB==null) {
					return null;
				}
				if(Fin==null) {
					return null;
				}else {
					//////////////////////////////
					if(Inicio.obtenerData()== AB.obtenerData()) {
						return this.eliminarAlInicio();
					}
					///////////////////////////////////
					if(Inicio.obtenerData()== AB.obtenerData()) {
						return this.eliminarAlFin();
		}
		///////////////////////////////////
				Nodo refRojo=Inicio;
				Nodo refAzul=null;
				Nodo refElim=null;
				boolean Encontrado=false;
				while((refRojo!=null)&&!Encontrado) {
					if(refRojo.obtenerData()==AB.obtenerData()) {
						Encontrado=true;
						refElim=refRojo;
						 NoElementos--;
					}
					refRojo=refRojo.Siguiente;
				}
				if(Encontrado) {
				refRojo=refElim.Anterior;
				refAzul=refElim.Siguiente;
				refRojo.Siguiente=refAzul;
				refAzul.Anterior=refRojo;
				refElim.Siguiente=null;
				refElim.Anterior=null;
				}
				return refElim;
				}
			}
			
			@Override
			public String toString() {
				String tmp="";
				if(Inicio==null) {
					return "";
				}
				Nodo ref=Inicio;
				while(ref!=null) {
					tmp=tmp+" "+ref.toString();
					ref=ref.Siguiente;
				}
				return tmp;
			}
			public String toStringRevers() {
				String tmp="";
				if(Fin==null) {
					return "";
				}
				Nodo ref=Fin;
				while(ref!=null) {
					tmp=tmp+" "+ref.toString();
					ref=ref.Anterior;
				}
				return tmp;
			}
			public Nodo porIndice(int p) {
				if(Inicio==null) {
					return null;
				}
				if(p>=NoElementos) {
					return null;
				}
				if(p<0) {
					return null;
				}
				int i=0;
				Nodo ref=Inicio;
				for (;i<p;i++) {
					ref=ref.Siguiente;
				}
				switch(ref.obtenerTipo()) {
				case 1:
					ref=new Nodo<Integer>((int)ref.obtenerData(),1);
					break;
				case 2:
					ref=new Nodo<Double>((double)ref.obtenerData(),2);
					break;
				case 3:
					ref=new Nodo<String>(""+ref.obtenerData(),3);
					break;
				case 4:
					ref=new Nodo<Float>((float)ref.obtenerData(),4);
					break;
				case 5:
					ref=new Nodo<Boolean>((boolean)ref.obtenerData(),5);
					break;
				case 6:
					ref=new Nodo<Character>((char)ref.obtenerData(),6);
					break;
				case 7:
					ref=new Nodo<Short>((short)ref.obtenerData(),7);
					break;
				case 8:
					ref=new Nodo<Long>((long)ref.obtenerData(),8);
					break;
					default:
						ref=new Nodo(ref.obtenerData(),ref.obtenerTipo());
				}
				return ref;
			}
}
