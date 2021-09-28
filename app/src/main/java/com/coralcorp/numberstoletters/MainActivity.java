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

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TextWatcher {

    TextView answer;
    StringBuilder builder;
    EditText numberInAndroid;
    NumbersInLetters convert;
    int length;
    String number;
    int firstThree; // numbers between 10^9 and 10^7
    int secondThree; // numbers between 10^6 and 10^4
    int lastThree; // numbers between 10^3 and 0

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        answer = findViewById(R.id.answer);
        builder = new StringBuilder();
        convert = new NumbersInLetters();
        numberInAndroid = findViewById(R.id.number);
        number = numberInAndroid.getText().toString();
        numberInAndroid.addTextChangedListener(this);
    }

    public void separar() {
        number = numberInAndroid.getText().toString();
        length = number.length();
        if (length > 9) {
            builder.append("No v\u00E1lido.");
        } else {
            boolean solitas;
            if (length < 3) {
                if (length == 0) lastThree = 0;
                else lastThree = Integer.parseInt(number);
                solitas = true;
            } else {
                lastThree = Integer.parseInt(number.substring(length - 3));
                solitas = false;
            }
            if (length > 3) {
                int m = length - 3;
                if (m > 3) m = m - 3;
                secondThree = Integer.parseInt(number.substring(length - (3 + m), length - 3));
            }
            if (length > 6)
                firstThree = Integer.parseInt(number.substring(0, length - 6));
            if (length > 6)
                builder.append(convert.milesOMillones(firstThree, false, false));
            if (length > 3)
                builder.append(" ").append(convert.milesOMillones(secondThree, true, false));
            builder.append(convert.centenas(lastThree, true, solitas));
        }
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
    @Override
    public void afterTextChanged(Editable s) {
        builder.delete(0, builder.toString().length());
        numberInAndroid = findViewById(R.id.number);
        separar();
        answer.setText(builder.toString());
    }
}
