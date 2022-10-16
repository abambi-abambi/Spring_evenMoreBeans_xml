package org.example2;

public class ClassicalMusic implements Music {

	public void myInit() {
		System.out.println("...object ClassicalMusic initialization...");
	}

	public void myDestroy() {
		System.out.println("...calling the myDestroy ClassicalMusic method...");
	}

	public String getSong() {
		return "Hungarian Rhapsody";
	}
}