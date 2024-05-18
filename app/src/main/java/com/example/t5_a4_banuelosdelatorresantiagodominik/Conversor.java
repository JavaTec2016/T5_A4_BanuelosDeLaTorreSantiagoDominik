package com.example.t5_a4_banuelosdelatorresantiagodominik;

import android.util.Log;

public class Conversor {
    int num = 0;
    char tipo = 'd';
    byte base = 10;
    char convert = 'b';

    //retorna el numero, o el caracter que representa el numero
    public String revisarExceso(int n){
        switch (n){
            case 10: return "A";
            case 11: return "B";
            case 12: return "C";
            case 13: return "D";
            case 14: return "E";
            case 15: return "F";
            default: return ""+n;
        }
    }
    //retorna el numero, o el numero que representa el caracter
    public byte obtenerExceso(char c){
        //obtiene la diferencia entre el numero y la base
        //si el numero alcanza a la base, retorna 10 mas la diferencia, de lo contrario solo el numero
        //se podria revisar cuantas veces alcanza la base
        if(Character.isDigit(c)){
            byte num = Byte.parseByte(""+c);
            byte alcance = (byte)(num/base*10);
            return (byte) (alcance+(num%base));
            //if(num-base >= 0) return (byte)(10+num-base);
            //return num;
        }
        //para convertir una letra hexadecimal a numero
        //el punto de inicio es A(10)
        //se toma la diferencia entre la letra y A (usualmente entre 0 a 5 caracteres de distanca)
        //se le suma 10 (entre 10 a 15);
        return (byte)((""+c).toUpperCase().charAt(0)-'A'+10);

    }
    public int aDecimal(String num){

        //Log.i("CONVERSOR", "Arrancando");
        int res = 0;
        for(int i = 0; i < num.length(); i++){
            byte n = obtenerExceso(num.charAt(i));
            int potencia = num.length()-i-1;
            Log.i("CONVERSOR", n+" x ("+base+") a la : "+potencia);
            res += n*(Math.pow(base, potencia));
        }
        Log.i("CONVERSOR", num+"("+base+") a decimal: "+res);
        return res;
    }
    public String convertirDecimal(int b){
        base = (byte)b;
        String res = "";
        int total = 0;
        double r = num;
        int n = 0;
        Log.i("CONVERSOR", "conviertiendo: "+num+"(10) a ("+base+")");
        do{
            n = (int)(r%base);
            //total = total*10+n;
            r = (r/base);
            Log.i("CONVERSOR", "Cociente: "+r+"(10) a ("+base+"), " + "Residuo: "+n+"(10) a ("+base+")");
            //Log.i("CONVERSOR", "Residuo: "+n+"(10) a ("+base+")");
            res =  revisarExceso(n) + res;
            Log.i("CONVERSOR", "Expresion: "+res+"("+base+")");
            //int redondear = (int)(r*10);



        }
        while(r > 2);

        if((int)r != 0) res = (int)r+res;
        Log.i("CONVERSOR", "convertido a "+res+"("+base+")");
        return res;
    }

}
