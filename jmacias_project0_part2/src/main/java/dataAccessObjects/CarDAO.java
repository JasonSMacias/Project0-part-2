package dataAccessObjects;

import beans.Car;

public interface CarDAO {
	public Car getCar(Car car);
	public Car addCar(Car newCar);
	// TODO this replaces a method that feeds a list and overwrites all cars in the 
	// file version.  references must be updated.
	public Car overwriteCar(Car car); 
	public Car removeCar(Car car);
	
}
