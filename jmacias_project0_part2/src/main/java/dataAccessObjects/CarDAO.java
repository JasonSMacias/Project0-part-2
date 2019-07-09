package dataAccessObjects;

import beans.Car;

public interface CarDAO {
	public Car getCar(int carId);
	public void addCar(Car newCar);
	// TODO this replaces a method that feeds a list and overwrites all cars in the 
	// file version.  references must be updated.
	public Car overwriteCar(Car car); 
	public void removeCar(int carId);
	
}
