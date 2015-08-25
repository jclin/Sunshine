package com.jclin.sunshine;

public final class Temperature
{
    private Temperature()
    {
    }

    public static double celsiusToFahrenheit(double celsiusTemp)
    {
        return celsiusTemp * 1.8d + 32;
    }
}
