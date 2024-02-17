package com.uce.edu.funcional;

@FunctionalInterface
public interface IPersona {

	public void camina();
	
	//public void comer();
	
	
}
//suupllier.-  la funcion no necesita ningun argumento pero si devolvera un tipo de dato determiado
//consumer.- la funcion recibe uno o dos argumentos, realizar una operacion con los argumentos y no retorna ningun resultado
//predicate.- la funcion recibe uno o dos argumentos, los procesa y devuelve un valor booleano
//Function.- la funcion uno dos argumentos, los procesa y devuelve otro tipo de dato
//Unary Operator.- la funcion es una derivada ya que recibe un tipo de argumento lo procesa y devuelve el mismo tipo del argumento