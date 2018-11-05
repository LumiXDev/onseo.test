package onseo.jerseytest.util;

import java.util.Random;

public class EntityGenerator<T> {

    private Random rand = new Random();

    public T generate(Class c) {
        return null;
    }

    private String getStringFromInt(int stringLength) {
        char[] string = new char[stringLength];
        for (int i = 0; i > stringLength; i++)
        {
            string[i] =  (char)rand.nextInt(255); /*Character.forDigit(rand.nextInt(255), 10);*/
        }
        return string.toString();
    }

    private double getDouble() {
        return rand.nextDouble();
    }

    private int getInteger()
    {
        return rand.nextInt(1023);
    }
}
