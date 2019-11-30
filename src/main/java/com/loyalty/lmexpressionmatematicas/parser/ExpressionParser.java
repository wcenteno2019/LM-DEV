package com.loyalty.lmexpressionmatematicas.parser;

import com.loyalty.lmexpressionmatematicas.interfaces.IExpressionParser;
import com.loyalty.lmexpressionmatematicas.pojos.ResponseExpression;
import com.loyalty.lmexpressionmatematicas.utils.Utility;
import org.springframework.stereotype.Service;

import java.util.Stack;
@Service("ExpressionData")
public class ExpressionParser implements IExpressionParser {

    @Override
    public Stack<String> obtenerPostfix(String expresion) {
        Stack<String> pSalida = new Stack<>();
        Stack<String> pOperador = new Stack<>();
        String[] exp = expresion.split("");
        //Recorremos la expression
        for (int i = 0; i<expresion.length(); ++i)
        {
            //Asignamos el primer valor
            String valor = exp[i];
            if (Utility.validaNumero(valor)) {//Validamos que sea numero
                pSalida.push(valor);
            }else
            {
                //Validamos si es operador y la gerarquia
                while (!pOperador.isEmpty() &&  Utility.pref(valor) <= Utility.pref(pOperador.peek())){
                    pSalida.push(pOperador.pop());
                }
                //Agregamos el operador a la pila de operadores
                if(Utility.pref(valor)==-1)return null;
                pOperador.push(valor);
            }
        }

        while (!pOperador.isEmpty()){
            pSalida.push(pOperador.pop());
        }
        return pSalida;
    }

    @Override
    public ResponseExpression response(String expression, Stack<String> expSalida, String valor) {
        ResponseExpression response = new ResponseExpression();

        response.setINFIXEXPRESSION(expression);
        response.setPOSTFIXEXPRESSION(Utility.depurar(Utility.convertString(expSalida)));
        response.setVALUE(valor);
        return response;

    }
}
