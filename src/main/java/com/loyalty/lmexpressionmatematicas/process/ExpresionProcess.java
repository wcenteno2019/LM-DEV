package com.loyalty.lmexpressionmatematicas.process;

import com.loyalty.lmexpressionmatematicas.interfaces.IExpressionParser;
import com.loyalty.lmexpressionmatematicas.interfaces.IExpressionProcess;
import com.loyalty.lmexpressionmatematicas.pojos.RequestExpression;
import com.loyalty.lmexpressionmatematicas.pojos.ResponseError;
import com.loyalty.lmexpressionmatematicas.pojos.ResponseExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Stack;

@Service("ExpressionProcess")
public class ExpresionProcess implements IExpressionProcess {
    private IExpressionParser iExpressionParser;
    @Autowired
    public ExpresionProcess(@Qualifier("ExpressionData") IExpressionParser iExpressionParser){
        this.iExpressionParser = iExpressionParser;

     }
    @Override
    public ResponseEntity modificarExpression(RequestExpression expression) {
        try{
        Stack<String> exprSalida = iExpressionParser.obtenerPostfix(expression.getExp());
        if(exprSalida != null) {
            ResponseExpression response = iExpressionParser.response(expression.getExp(), exprSalida, "");
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else
        {
            ResponseError error = new ResponseError();
            error.setMessage("This Expression " +expression.getExp() + " is invalid");
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
        }catch (Exception e){
            ResponseError error = new ResponseError();
            error.setMessage("Some error ocurred while processing the expression");
            return new ResponseEntity<>(error,HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }
}
