/*
 * Copyright (c) 2021 SilverVS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.coralcorp.numberstoletters;

public class NumbersInLetters {
    public String unidades(int i) {
        switch (i) {
            case 1:
                return "uno";
            case 2:
                return "dos";
            case 3:
                return "tres";
            case 4:
                return "cuatro";
            case 5:
                return "cinco";
            case 6:
                return "seis";
            case 7:
                return "siete";
            case 8:
                return "ocho";
            case 9:
                return "nueve";
            default:
                return ".";
        }
    }

    public String decenas(int i) {
        switch (i) {
            case 1:
                return "diez ";
            case 2:
                return "veinte ";
            case 3:
                return "treinta ";
            case 4:
                return "cuarenta ";
            case 5:
                return "cincuenta ";
            case 6:
                return "sesenta ";
            case 7:
                return "ochenta ";
            case 8:
                return "noventa ";
            default:
                return " ";
        }
    }

    public String diezAVeinte(int i, int ceros) {
        StringBuilder build = new StringBuilder();
        if (i < 20) {
            int num = i - 10;
            switch (num) {
                case 1:
                    return "once";
                case 2:
                    return "doce";
                case 3:
                    return "trece";
                case 4:
                    return "catorce";
                case 5:
                    return "quince";
                default:
                    build.append("dieci").append(unidades(num));
            }
        } else {
            int num = i - 20;
            if (num == 1 && ceros == 3) {
                return "veintiun";
            } else {
                build.append("veinti").append(unidades(num));
            }

        }
        return build.toString();
    }

    public String centenas(int i) {
        StringBuilder builder = new StringBuilder();
        switch (i) {
            case 1:
                return "cien";
            case 5:
                return "quinientos";
            case 9:
                builder.append("nove");
            default:
                builder.append(unidades(i));
        }
        builder.append("cientos");
        return builder.toString();
    }

    public String millares(int i){
        StringBuilder builder = new StringBuilder();
        if (i == 1 || i == 0) {
            return "mil";
        } else if (i<10){
            builder.append(unidades(i));
            // Aquí no c que le moví
        } else if (i>10 && i<20){
            builder.append(decenas(i));
        }
        builder.append("mil");
        return builder.toString();
    }
}
