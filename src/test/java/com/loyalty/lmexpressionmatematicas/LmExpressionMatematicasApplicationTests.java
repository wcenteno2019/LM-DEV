package com.loyalty.lmexpressionmatematicas;

import com.loyalty.lmexpressionmatematicas.interfaces.IExpressionParser;
import com.loyalty.lmexpressionmatematicas.utils.Utility;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.Stack;

@SpringBootTest
class LmExpressionMatematicasApplicationTests {

	private IExpressionParser expressionParser;
	@Autowired
	public LmExpressionMatematicasApplicationTests(@Qualifier("ExpressionData")IExpressionParser expressionParser){
		this.expressionParser = expressionParser;
}

	//valida si es numero
	@Test
	void validaNumero() {
		String inpunt = "1";

		Assert.assertTrue(Utility.validaNumero(inpunt));
	}

	//valida si es numero
	@Test
	void validaNoNumero() {
		String inpunt = "/";

		Assert.assertFalse(Utility.validaNumero(inpunt));
	}
	//Obtener pila de respuesta
	@Test
	void pruebaObtenerPostFix(){
		String expr = "1+2.5/3*4";
		Stack<String> psalida = expressionParser.obtenerPostfix(expr);

		String str =Utility.depurar(Utility.convertString(psalida));

		String strEsperado="12.53/4*+";
		Assert.assertEquals(str,strEsperado);

	}

	//Obtener pila de respuesta
	@Test
	void pruebaInvalidExpre(){
		String expr = "1+2.5/3*4A";
		Stack<String> psalida = expressionParser.obtenerPostfix(expr);


		Assert.assertNull(psalida);

	}
	@Test
	void obtenerValor(){
		String str="12.53/4*+";
		String[] post = str.split("");

		//Declaración de las pilas
		Stack < String > E = new Stack < String > (); //Pila entrada
		Stack < String > P = new Stack < String > (); //Pila de operandos




		//Añadir post (array) a la Pila de entrada (E)
		for (int i = post.length - 1; i >= 0; i--) {
			E.push(post[i]);
		}

		//Algoritmo de Evaluación Postfija
		String operadores = "+-*/.";
		while (!E.isEmpty()) {
			if (operadores.contains("" + E.peek())) {
				P.push(evaluar(E.pop(), P.pop(), P.pop()) + "");
			}else {
				P.push(E.pop());
			}
		}

		//Mostrar resultados:
		System.out.println("Expresion: " + str);
		System.out.println("Resultado: " + P.peek());

	}

	private static int evaluar(String op, String n2, String n1) {
		if (op.equals(".")) return 0;
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		if (op.equals("+")) return (num1 + num2);
		if (op.equals("-")) return (num1 - num2);
		if (op.equals("*")) return (num1 * num2);
		if (op.equals("/")) return (num1 / num2);

		return 0;

	}

}
