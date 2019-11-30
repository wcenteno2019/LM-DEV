package com.loyalty.lmexpressionmatematicas.interfaces;

import com.loyalty.lmexpressionmatematicas.pojos.ResponseExpression;

import java.util.Stack;

public interface IExpressionParser {

    public Stack<String> obtenerPostfix(String expresion);
    public ResponseExpression response(String expression, Stack<String> expSalida, String valor);
}
