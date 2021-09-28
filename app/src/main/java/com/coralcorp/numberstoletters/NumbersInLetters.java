/*
 * Copyright (c) 2021 SilverVS
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the “Software”), to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and
 * to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NON INFRINGEMENT. IN NO EVENT SHALL THE AUTHORS
 * OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.coralcorp.numberstoletters;

public class NumbersInLetters {

    public String unidades(int i) {
        switch (i) {
            case 0:
                return "cero";
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
            case 10:
                return "diez";
            default:
                return "";
        }
    }

    public String decenas(int a, boolean lastDigits, boolean alone) {
        StringBuilder builder = new StringBuilder();
        if (a < 11) {
            return unidades(a);
        }
        int residue = a % 10;
        if (a < 30 && a != 20) {
            return diezAVeinte(a, lastDigits);
        } else {
            int i = a - residue;
            switch (i) {
                case 20:
                    builder.append("veinte");
                    break;
                case 30:
                    builder.append("treinta");
                    break;
                case 40:
                    builder.append("cuarenta");
                    break;
                case 50:
                    builder.append("cincuenta");
                    break;
                case 60:
                    builder.append("sesenta");
                    break;
                case 70:
                    builder.append("setenta");
                    break;
                case 80:
                    builder.append("ochenta");
                    break;
                case 90:
                    builder.append("noventa");
                    break;
                default:
                    break;
            }
            if (residue != 0 && (!alone || lastDigits))
                builder.append(" y ").append(unidades(residue));
            return builder.toString();
        }
    }

    public String diezAVeinte(int i, boolean lastDigits) {
        StringBuilder builder = new StringBuilder();
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
                    builder.append("dieci").append(unidades(num));
            }
        } else {
            int num = i - 20;
            if (num == 1 && !lastDigits) {
                return "veintiun";
            } else {
                builder.append("veinti").append(unidades(num));
            }

        }
        return builder.toString();
    }

    public String centenas(int a, boolean lastDigits, boolean alone) {
        StringBuilder builder = new StringBuilder();
        if (alone) {
            return decenas(a, true, true);
        }
        int residue = a % 100;
        int i = (a - residue) / 100;
        boolean flagCientos = false;
        if (i == 1) {
            if (residue != 0) builder.append("ciento");
            else builder.append("cien");
        } else if (i == 5) {
            builder.append("quinientos");
        } else if (i == 9) {
            builder.append("nove");
        } else if (i != 0) {
            builder.append(unidades(i));
            flagCientos = true;
        }
        if (flagCientos)
            builder.append("cientos");
        if (residue != 0) {
            builder.append(" ").append(decenas(residue, lastDigits, false));
        }
        return builder.toString();
    }

    public String milesOMillones(int i, boolean miles, boolean lastDigits) {
        StringBuilder builder = new StringBuilder();

        if (i == 1 || i == 0) {
            if (miles) {
                return "mil ";
            } else {
                if (i == 1)
                    return "un mill\u00F3n";
            }
        } else if (i < 10) {
            builder.append(unidades(i));
        } else if (i < 100) {
            builder.append(decenas(i, lastDigits, false));
        } else {
            builder.append(centenas(i, false, false));
        }
        if (miles) {
            builder.append(" mil ");
        } else {
            builder.append(" millones");
        }
        return builder.toString();
    }
}
