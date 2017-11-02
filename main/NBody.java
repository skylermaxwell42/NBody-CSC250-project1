package com.csc250Fall2017.project1;

public class NBody {
	public static void main(String[] args) {
		double time, deltaTime, radius;
		String fileName;
		Planet[] a_planets;

		// Parsing arguments
		time = Double.parseDouble(args[0]);
		deltaTime = Double.parseDouble(args[1]);
		fileName = args[2];

		// Reading data from 'planets.txt'
		a_planets = readPlanets(fileName);
		radius = readRadius(fileName);

		// Drawing the background (stars)
		String backgroundImg = "starfield.jpg";
		StdDraw.setScale(-(radius/2), (radius/2));
		StdDraw.clear();
		StdDraw.picture(-(radius/2), (radius/2), backgroundImg);

		for (int i = 0; i < a_planets.length; i++) {
			a_planets[i].drawPlanet();
		}

    	}
	public static double readRadius(String fileName) {
		In in = new In(fileName);
		double radius, numPlanets = 0;

		numPlanets = in.readInt();
		radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String fileName) {
		In in = new In(fileName);
		double xPos, yPos, xVel, yVel, mass, radius;
		String imgFileName;
		int numPlanets;

		numPlanets = in.readInt();
		radius = in.readDouble();

		Planet[] a_planets = new Planet[numPlanets];

		for (int i = 0; i < numPlanets; i++) {
			xPos = in.readDouble();
			yPos = in.readDouble();
			xVel = in.readDouble();
			yVel = in.readDouble();
			mass = in .readDouble();
			imgFileName = in.readString();

			a_planets[i] = new Planet(xPos, yPos, xVel, yVel, mass, imgFileName);
		}
		return a_planets;
	}
}
