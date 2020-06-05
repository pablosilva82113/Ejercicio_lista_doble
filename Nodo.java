public class Nodo <T>{
		public Nodo Anterior;
		public Nodo Siguiente;
		private int Tipo;
		private T Data;
		public Nodo(T Data,int Tipo) {
			this.Tipo=Tipo;
			this.Data=Data;
			 Anterior=null;
			 Siguiente=null;
			
		}
		public T obtenerData() {
			return Data;
		}
		public void asignarData(T Data) {
			this.Data=Data;
		}
		public String toString() {
			return ""+Data;
		}
		public int obtenerTipo() {
			return Tipo;
		}
	}