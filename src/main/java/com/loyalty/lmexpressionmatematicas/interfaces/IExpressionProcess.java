package com.loyalty.lmexpressionmatematicas.interfaces;

import com.loyalty.lmexpressionmatematicas.pojos.RequestExpression;
import org.springframework.http.ResponseEntity;

public interface IExpressionProcess  {
    public ResponseEntity modificarExpression (RequestExpression expression);


}
