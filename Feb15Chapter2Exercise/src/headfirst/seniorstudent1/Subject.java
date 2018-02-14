/*
 * Subject.java 1.0 Feb. 14, 2018
 *
 * Copyright (c) 2018 HFDP
 */
package headfirst.seniorstudent1;

public interface Subject {

  public void notifyObservers();

  public void registerObserver(Observer o);

  public void removeObserver(Observer o);
}
