package com.loyalty.lmexpressionmatematicas.utils;

import java.util.Iterator;
import java.util.Stack;

public class Utility {

    public static boolean validaNumero(String dato) {
        if (dato.matches("[0-9]")) {
            return true;
        }
        if(dato.equalsIgnoreCase(".")){
            return true;
        }
        return false;
    }


    public static  int pref(String op) {
        switch (op)
        {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
        }
        return -1;

    }
    public static String depurar(String s) {
        s = s.replaceAll(",\\s", ""); //Elimina espacios en blanco y comilla
        String simbols = "+-*/";
        String str = "";

        //Deja espacios entre operadores
        for (int i = 0; i < s.length(); i++) {
            if (simbols.contains("" + s.charAt(i))) {
                str +=  s.charAt(i);
            }else str += s.charAt(i);
        }
        return str;
    }
    public static String convertString(Stack<String> expr){

        String res = "";
        Iterator<String> itr = expr.iterator();
        while(itr.hasNext()){
            res += itr.next().toString();

            }
        return res;
    }
}
