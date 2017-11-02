package com.csc250Fall2017.project1;

import java.lang.*;

public class Planet {

	private double m_xPos;
	private double m_yPos;
	private double m_xVel;
	private double m_yVel;
	private double m_mass;
	private String m_imgFileName;

	public Planet(double xPos, double yPos, double xVel, double yVel, double mass, String imgFileName) {
		m_xPos = xPos;
		m_yPos = yPos;
		m_xVel = xVel;
		m_yVel = yVel;
		m_mass = mass;
		m_imgFileName = imgFileName;
	}

	public Planet(Planet copyPlanet) {
		this   (copyPlanet.getxPos(),
			copyPlanet.getyPos(),
			copyPlanet.getxVel(),
			copyPlanet.getyVel(),
			copyPlanet.getMass(),
			copyPlanet.getImgFileName());
	}

	public double calcDistance(Planet planet1) {
		double xPos1, yPos1, xDist, yDist, totalDist;

		xPos1 = planet1.getxPos();
		yPos1 = planet1.getyPos();
		xDist = Math.abs(xPos1 - m_xPos);
		yDist = Math.abs(yPos1 - m_yPos);
		totalDist = Math.sqrt((xDist*xDist) + (yDist*yDist));
		return totalDist;
	}

	public double calcForceExertedBy(Planet planet1) {
		double totalDist, forceExerted;
		double G = 6.67e-11;

		totalDist = calcDistance(planet1);
		forceExerted = (G * m_mass * planet1.getMass()) / (totalDist*totalDist);
		return forceExerted;
	}

	public double calcForceExertedByX(Planet planet1) {
		double xPos1, xDist, xForce;

		xPos1 = planet1.getxPos();
		xDist = Math.abs(m_xPos - xPos1);
		xForce = calcForceExertedBy(planet1) * xDist / calcDistance(planet1);
		return xForce;
	}

	public double calcForceExertedByY(Planet planet1) {
		double yPos1, yDist, yForce;

		yPos1 = planet1.getyPos();
		yDist = Math.abs(m_yPos - yPos1);
		yForce = calcForceExertedBy(planet1) * yDist / calcDistance(planet1);
		return yForce;
	}

	public double calcNetForceExertedByX(Planet [] a_planets) {
		double netForceX = 0;

		for (int i = 0; i < a_planets.length; i++) {
			if (this.equals(a_planets[i])) {
				netForceX += calcForceExertedByX(a_planets[i]);
			}
		}
		return netForceX;
	}

        public double calcNetForceExertedByY(Planet [] a_planets) {
                double netForceY = 0;

                for (int i = 0; i < a_planets.length; i++) {
			if (this.equals(a_planets[i])) {
	                        netForceY += calcForceExertedByY(a_planets[i]);
			}
                }
                return netForceY;
        }

	public void update(double time, double xForce, double yForce) {
		double xAccel, yAccel;

		xAccel = xForce / m_mass;
		yAccel = yForce / m_mass;

		m_xVel += xAccel * time;
		m_yVel += yAccel * time;

		m_xPos += m_xVel * time;
		m_yPos += m_yVel * time;
		return;
	}

	public void drawPlanet() {

		StdDraw.picture(m_xPos, m_yPos, m_imgFileName);
	}

	public double getxPos() {
		return m_xPos;
	}

	public void setxPos(double xPos) {
		m_xPos = xPos;
		return;
	}

	public double getyPos() {
		return m_yPos;
	}

	public void setyPos(double yPos) {
		m_yPos = yPos;
		return;
	}

	public double getxVel() {
		return m_xVel;
	}

	public void setxVel(double xVel) {
		m_xVel = xVel;
		return;
	}

	public double getyVel() {
		return m_yVel;
	}

	public void setyVel(double yVel) {
		m_yVel = yVel;
		return;
	}

	public double getMass() {
		return m_mass;
	}

	public void setMass(double mass) {
		m_mass = mass;
		return;
	}

	public String getImgFileName() {
		return m_imgFileName;
	}

	public void setImgFileName(String imgFileName) {
		m_imgFileName = imgFileName;
		return;
	}
}
