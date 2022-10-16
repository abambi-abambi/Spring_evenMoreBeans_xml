package org.example2;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml"
		);
/* Variant 1, old java: no beans */
		Music music4 = new ClassicalMusic();
		MusicPlayer musicPlayer1 = new MusicPlayer(music4);

/* Variant 2, 1 bean-object (gets into the constructor) + 1 old java object creation */
		Music music1_1 = context.getBean("mymusic1", RockMusic.class);
		Music music1_2 = context.getBean("mymusic1", RockMusic.class);
// beans are [by default] Singletones:
		System.out.println("Compare objects, 1: " + (music1_1 == music1_2));
		MusicPlayer musicPlayer2 = new MusicPlayer(music1_1);

/* Variant 3, all objects are beans from the context (1 bean goes to the 2nd-bean constructor) */
		MusicPlayer musicPlayer3 = context.getBean("myplayer1", MusicPlayer.class);

/* Variant 4, using bean-setter */
		MusicPlayer musicPlayer4_1 = context.getBean("myplayer2", MusicPlayer.class);
		MusicPlayer musicPlayer4_2 = context.getBean("myplayer2", MusicPlayer.class);
// beans are [hand-setted] Prototypes:
		System.out.println("Compare objects, 2: " + (musicPlayer4_1 == musicPlayer4_2));

/* this works near to:
		MusicPlayer musicPlayer4 = new MusicPlayer();
		musicPlayer4.setMusic(); */

/* Variant 5, with init- / destroy-methods in the bean */
		Music music2 = context.getBean("mymusic2", ClassicalMusic.class);
		MusicPlayer musicPlayer5 = new MusicPlayer(music2);

/* Variant 6, using bean with factory pattern */
		Music music3_1 = context.getBean("mymusic3", ModernMusic.class);
		Music music3_2 = context.getBean("mymusic3", ModernMusic.class);
		System.out.println("Compare factory objects, 3: " + (music3_1 == music3_2));

/* Variant 7, using bean-setter & the outer file for names:values */
		MusicPlayer musicPlayer6 = context.getBean("myplayer3", MusicPlayer.class);
		MusicPlayer musicPlayer7 = context.getBean("myplayer3", MusicPlayer.class);

/* Start the music */
		musicPlayer1.playMusic();
		musicPlayer2.playMusic();
		musicPlayer3.playMusic();
		musicPlayer4_1.playMusic();
		musicPlayer5.playMusic();
		musicPlayer6.playMusic();
		musicPlayer7.playMusic();

		musicPlayer5.setName("First Player");
		musicPlayer5.setVolume(5);

		System.out.println("Name of musical player 4_1: '" + musicPlayer4_1.getName() +
				"', volume level while playing: " + musicPlayer4_1.getVolume());
		System.out.println("Name of musical player 5: '" + musicPlayer5.getName() +
				"', volume level while playing: " + musicPlayer5.getVolume());
		System.out.println("Name of musical player 6: '" + musicPlayer6.getName() +
				"', volume level while playing: " + musicPlayer6.getVolume());
		System.out.println("Name of musical player 7: '" + musicPlayer7.getName() +
				"', volume level while playing: " + musicPlayer7.getVolume());

		musicPlayer6.setName("New Player");
		musicPlayer6.setVolume(12);

		System.out.println("Name of musical player 4_1: '" + musicPlayer4_1.getName() +
				"', volume level while playing: " + musicPlayer4_1.getVolume());
		System.out.println("Name of musical player 5: '" + musicPlayer5.getName() +
				"', volume level while playing: " + musicPlayer5.getVolume());
		System.out.println("Name of musical player 6: '" + musicPlayer6.getName() +
				"', volume level while playing: " + musicPlayer6.getVolume());
		System.out.println("Name of musical player 7: '" + musicPlayer7.getName() +
				"', volume level while playing: " + musicPlayer7.getVolume());

		context.close();
	}
}
