package org.example2;

public class ModernMusic implements Music {

	private ModernMusic() {}

//	tiny factory pattern
	public static ModernMusic getModernMusic() {
		return new ModernMusic();
	}

	public String getSong() {
		return "Very modern music";
	}
}
