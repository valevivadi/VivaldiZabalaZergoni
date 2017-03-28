package nmm;

import framework.AdversarySearchState;



/*El estado del juego va a tener las fichas que tiene  el jugador  y el cpu disponibles 
 * para insertar!
 * 
 * tambien guarda si el estado es max o min y guarda el turno del jugador corriente,
 * el valor 1 representa el turno del jugador y el 2 el del cpu, estos tambien representa
 * la ficha de cada uno, respectivamente.
 * 
 * -el movimientoAplicado es el movimiento que se realizo para llegar al estado
 * 
 * - el tablero contiene las fichas jugadas
 * 
 * */
public class EstadoNMM implements AdversarySearchState {
	private int fichasJ;
	private int fichasCPU;
	
	private boolean max; 	 /*true es max si es false es min*/
	private int turn; 		/* 2 si es la maquina y 1 si es el jugador*/
	
	
	private String movimientoAplicado;
	private int[] tablero;
	
	

	/*constructora de la clase*/
	public EstadoNMM(boolean maxx,int turnn, String mov,int[]tabl,int fichj,int fichcpu){
		max=maxx;
		turn=turnn;
		movimientoAplicado=mov;
		tablero=tabl;
		
		fichasJ=fichj;
		fichasCPU=fichcpu;
	}
	
	
	
	/* devuelve si el estado es max*/
	public boolean isMax() {
		
		return max;
	}

	
	/*indica si dos estados son iguales*/
	public boolean equals(EstadoNMM other) {
		boolean res =true;
		if(this.max!=other.max){res=false;}
		if(this.fichasJ!=other.fichasJ){res=false;}
		if(this.fichasCPU!=other.fichasCPU){res=false;}
		if(this.movimientoAplicado!=other.movimientoAplicado){res=false;}
		if(this.turn!=other.turn){res=false;}
		for(int i=0;i<24;i++){if(this.tablero[i]!=other.tablero[i]){res=false;}}
		
		return res ;
		
	}

	
	/*devuelve el movimiento aplicado del estado */
	public Object ruleApplied() {
		
		return movimientoAplicado;
	}


	/* retorna el tablero del estado*/
	public int[] getTablero(){
		return tablero;
		
		
	}
	/*retorna el turno corriente del estado*/
	public int getTurn(){
		return turn;
	}
	/* Devuelve el movimiento aplicado del estado*/
	public String getMovAp(){
		return movimientoAplicado;
	}
	
	/*devuelve las fichas disponibles para insertar del jugador*/
	public int getFichasJ(){
		return fichasJ;
	}
	/* devuelve las fichas disponibles para insertar del cpu*/
	public int getFichasCPU(){
		return fichasCPU;
	}


	/* Muestra el tablero con las fichas en cada posicion del mismo. el 0 representa que
	 * esta vacio, al lado se encuentra una guia con las coordenadas correspondientes a 
	 * cada posicion.
	 * */
	
	public void imprimir() {
		System.out.println("TABLERO DE JUEGO            GUIA DE COORDENADAS!");
		System.out.println(movimientoAplicado);
		System.out.println();
		
		System.out.println(tablero[0]+"--------"+tablero[1]+"--------"+tablero[2]+"          "+"0--------"+"1--------2");
		System.out.println("|        |        |"+"          "+"|        |        |");
		
		System.out.println("|  "+tablero[3]+"-----"+tablero[4]+"-----"+tablero[5]+"  |"+"          "+"|  "+"3-----4"+"-----5"+"  |");
		System.out.println("|  |     |     |  |"+"          "+"|  |     |     |  |");

		System.out.println("|  |  "+tablero[6]+"--"+tablero[7]+"--"+tablero[8]+"  |  |"+"          "+"|  |  "+"6--7"+"--8"+"  |  |");
		System.out.println("|  |  |     |  |  |"+"          "+"|  |  |     |  |  |");
		
		System.out.println(tablero[9]+"--"+tablero[10]+"--"+tablero[11]+"     "+tablero[12]+"--"+tablero[13]+"--"+tablero[14]+"          "+"9-10"+"-11"+"     "+"12-13"+"-14");
		
		System.out.println("|  |  |     |  |  |"+"          "+"|  |  |     |  |  |");
		System.out.println("|  |  "+tablero[15]+"--"+tablero[16]+"--"+tablero[17]+"  |  |"+"          "+"|  |  "+"15-16"+"-17"+" |  |");
		System.out.println("|  |     |     |  |"+"          "+"|  |     |     |  |");
		System.out.println("|  "+tablero[18]+"-----"+tablero[19]+"-----"+tablero[20]+"  |"+"          "+"|  "+"18----19"+"----20"+" |");
		System.out.println("|        |        |"+"          "+"|        |        |");
		
		System.out.println(tablero[21]+"--------"+tablero[22]+"--------"+tablero[23]+"          "+"21-------22"+"-------23");
		
		System.out.println();
		System.out.println();
		System.out.println();
		
	}



	@Override
	public boolean equals(AdversarySearchState other) {
		// TODO Auto-generated method stub
		return false;
	}
	



}
