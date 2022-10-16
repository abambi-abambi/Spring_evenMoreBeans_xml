package org.example2;

public class MusicPlayer {
	private String	name;
	private Music	music;
	private int		volume;

	public MusicPlayer() {
	}

	public MusicPlayer(Music music) {
		this.music = music;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMusic(Music music) {
		this.music = music;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

	public String getName() {
		return name;
	}

	public int getVolume() {
		return volume;
	}

	public void playMusic() {
		System.out.println("Playing: " + music.getSong());
	}
}
