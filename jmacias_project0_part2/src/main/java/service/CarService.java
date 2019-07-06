package service;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import beans.Car;

public class CarService {
	// TODO finish adding method equivalents to these to carController and delete this file.

	public static List<Car> getCars() {
		List<Car> cars = null;
		try(ObjectInputStream str = new ObjectInputStream(new FileInputStream(new File(".\\src\\main\\resources\\cars.txt")))) {
			cars = (List<Car>) str.readObject();
		}
		catch (Exception e) {
			return new ArrayList<>();
		}
		return cars;
	}
	
	public static void addCar(Car newCar) throws FileNotFoundException, IOException {
		List<Car> cars = getCars();
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(".\\src\\main\\resources\\cars.txt")))) {
			if (cars != null) {
				System.out.println("Car data found, adding to cars.");
				cars.add(newCar);
			}
			else {
				System.out.println("This is the first car.");
				cars = new ArrayList<>();
				cars.add(newCar);
			}
			oos.writeObject(cars);
		}
		System.out.println("Cars updated.");
	}
	
	public static void overwriteCars(List<Car> cars) throws FileNotFoundException, IOException {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File(".\\src\\main\\resources\\cars.txt")))) {
			oos.writeObject(cars);
		}
	}
	
	public static void removeCars(int carNumber) throws FileNotFoundException, IOException {
		List<Car> cars = getCars();
		for (Car x : cars) {
			if (x.number == carNumber) {
				cars.remove(x);
				break;
			}
		}
		overwriteCars(cars);
	}
}