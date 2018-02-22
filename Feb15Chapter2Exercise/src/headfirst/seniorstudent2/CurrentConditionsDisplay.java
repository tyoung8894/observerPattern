/*
 * CurrentConditionsDisplay.java 1.0 Feb. 14, 2018
 *
 * Copyright (c) 2018 HFDP
 */
package headfirst.seniorstudent2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import java.util.Observable;
import java.util.Observer;

public class CurrentConditionsDisplay extends JFrame implements Observer {

  private JTextField humidityTextField;
  private JTextField pressureTextField;
  private JTextField temperatureTextField;
  //private WeatherData weatherData;
  Observable observable;

  public CurrentConditionsDisplay(Observable weatherData, int x, int y) {
    this.setTitle("Current Conditions");
    //this.weatherData = (WeatherData) weatherData;
    this.observable = weatherData;
    observable.addObserver(this);
    // Key to register his observer with Observable.
    //addObserver(this.weatherData);
    createGui();
    this.setLocation(x, y);
    this.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    this.addWindowListener(new WindowAdapter() {
      /**
       * Remove the observer from the Subject so no attempt is made by Subject to nofify a non
       * existing instance that is closed
       */
      @Override
      public void windowClosing(WindowEvent e) {
        System.out.println("Removed observer");
        removeTheObserver();
      }
    });
    this.pack();
    this.setVisible(true);
  }

  /**
   * Observer method called when data changes in WeatherData. The method supplies the three data
   * values needed by GUI
   * 
   * @param temperature float of temperature in degrees
   * @param humidity float of relative humidity
   * @param pressure float of the measured barometric pressure
   * @see headfirst.seniorstudent1.Observer#updateData(float, float, float)
   */
 /* @Override
  public void updateData(float temperature, float humidity, float pressure) {
    temperatureTextField.setText("" + temperature);
    humidityTextField.setText("" + humidity);
    pressureTextField.setText("" + pressure);
  }*/
  
  public void update(Observable obs, Object arg) {
	  if (obs instanceof WeatherData) {
		  WeatherData weatherData = (WeatherData) obs;
		  temperatureTextField.setText("" + weatherData.getTemperature());
		  humidityTextField.setText("" + weatherData.getHumidity());
		  pressureTextField.setText("" + weatherData.getPressure());
	  }
  }

  private void createGui() {
    Container container = this.getContentPane();
    JPanel holdGrid = new JPanel();
    JPanel leftGrid = new JPanel();
    JPanel rightGrid = new JPanel();

    leftGrid.setLayout(new GridLayout(3, 1));
    leftGrid.add(new JLabel("Current Temperature ", SwingConstants.RIGHT));
    leftGrid.add(new JLabel("Current Humidity ", SwingConstants.RIGHT));
    leftGrid.add(new JLabel("Current Pressure ", SwingConstants.RIGHT));

    rightGrid.setLayout(new GridLayout(3, 1));
    rightGrid.add(temperatureTextField = new JTextField("0", 10));
    rightGrid.add(humidityTextField = new JTextField("0", 10));
    rightGrid.add(pressureTextField = new JTextField("0", 10));

    holdGrid.setLayout(new BorderLayout(5, 0));
    holdGrid.add(leftGrid, BorderLayout.WEST);
    holdGrid.add(rightGrid, BorderLayout.CENTER);
    container.add(holdGrid, BorderLayout.CENTER);
  }

  private void removeTheObserver() {
    //weatherData.removeObserver(this);
    observable.deleteObserver(this);
  }

}
