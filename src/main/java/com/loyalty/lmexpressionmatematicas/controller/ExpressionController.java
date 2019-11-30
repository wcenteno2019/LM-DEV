package com.loyalty.lmexpressionmatematicas.controller;

import com.loyalty.lmexpressionmatematicas.interfaces.IExpressionProcess;
import com.loyalty.lmexpressionmatematicas.pojos.RequestExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expression")
public class ExpressionController {

    private IExpressionProcess process;

    @Autowired
    public ExpressionController (@Qualifier("ExpressionProcess") IExpressionProcess process){
        this.process = process;
    }

    @PostMapping("/evaluate")
    public ResponseEntity getExpressionPostFix(@RequestBody RequestExpression request){
        return process.modificarExpression(request);
    }
}
