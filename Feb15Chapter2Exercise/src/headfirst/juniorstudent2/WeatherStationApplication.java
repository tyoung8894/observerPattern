/*
 * WeatherStationApplication.java 1.0 Feb. 14, 2018
 *
 * Copyright (c) 2018 HFDP and DJP
 */

package headfirst.juniorstudent2;

import javax.swing.JFrame;

public class WeatherStationApplication {

  public static void main(String[] args) {
    WeatherData weatherData;
    CurrentConditionsDisplay display1 = new CurrentConditionsDisplay(300, 10);
    CurrentConditionsDisplay display2 = new CurrentConditionsDisplay(300, 150);
    CurrentConditionsDisplay display3 = new CurrentConditionsDisplay(300, 290);

    weatherData = new WeatherData(display1, display2, display3);
    JFrame control = new WeatherStationControlGUI(weatherData);
  }
}
