package nmm;

import java.util.List;

import framework.AdversarySearchEngine;
import framework.AdversarySearchProblem;
import framework.AdversarySearchState;

public class MinMaxNMM extends AdversarySearchEngine<ProblemaNMM, EstadoNMM> {
	
	/*Constructora del engine
	 * 
	 * */
	public MinMaxNMM(ProblemaNMM problema,int prof){
		super();
		problem =problema;
		maxDepth = prof;
	}

	/*calcula el el valor del estado pasado como parametro*/
	public int computeValue(EstadoNMM state) {
		
		return computeValue(state,maxDepth,-1000,1000);
	}
	/*llamada recursiva del computeValue*/
	private int computeValue(EstadoNMM state, int depth, int alpha, int beta) {
		if(problem.end(state)|| depth ==0){
			return problem.value(state);
		}else{
			List<EstadoNMM> sucesores= problem.getSuccessors(state);
			for(int i=0;(i<sucesores.size()&&alpha<beta);i++){
				if(state.isMax()){
					alpha=Math.max(alpha, computeValue(sucesores.get(i),depth-1,alpha,beta));
				}else{
					beta=Math.min(beta, computeValue(sucesores.get(i),depth-1,alpha,beta));
				}
			}
			if(state.isMax()){
				return alpha;
				}
			else{
				return beta;
			}
		}
	}

	/*dado un estado pasado como parametro, devuelve el mejor sucesor que tiene (o sea , hace el "mejor" 
	 * movimiento)*/
	public EstadoNMM computeSuccessor(EstadoNMM state) {
		List<EstadoNMM> sucesores = problem.getSuccessors(state);
		EstadoNMM mejorEstado=null;
		int valorMejorEstado;
		if(state.isMax()){valorMejorEstado=-10000;}else{valorMejorEstado=10000;}
		for(int i=0;i<sucesores.size();i++){
			EstadoNMM estadoaux =sucesores.get(i);
			int valoraux =computeValue(estadoaux);
			if(state.isMax()&&valoraux>valorMejorEstado){
				mejorEstado=estadoaux;
				valorMejorEstado=valoraux;
			}
			if((!state.isMax())&&valoraux<valorMejorEstado){
				mejorEstado=estadoaux;
				valorMejorEstado=valoraux;
			}
		
		}
		return mejorEstado;
		
	}
	
	
	



	@Override
	public void report() {
		

	}



}