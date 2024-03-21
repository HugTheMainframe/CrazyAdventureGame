import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Maps {
    private Rooms currentRoom;


    public Maps() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
        buildMap();

    }

    public void buildMap() throws UnsupportedAudioFileException, LineUnavailableException, IOException {
       Rooms room1 = new Rooms("\"Dungeon\" ", "\n" +
                "Torches flicker dimly, casting eerie shadows on the cold stone walls.\n" +
                "The feeling of foreboding intensifies, as if unseen eyes are watching my every move.\n"
                , 12);

        Rooms room2 = new Rooms("\"Prison\" " , "I find myself in a desolate prison" +
                 "\n" +
                "Its walls lined with rusted iron bars. The echoes of suffering linger here" +"" +
                "\n" +
                "I can't shake the feeling of being watched, as if the spirits of the damned still haunt these forsaken halls.", 10);

        Rooms room3 = new Rooms("\"Cave\" " , "\n" +
                "I find solace in the natural sanctuary of a dark, echoing cave. \n" +
                "Shadows dance along the walls.\n", 12);

        Rooms room4 = new Rooms("\"Forest\" " , "\n" +
                "I find myself amidst the dense foliage of an ancient forest. \n" +
                "Towering trees loom overhead, their branches intertwined like gnarled fingers reaching towards the sky. \n", 14);

        Rooms room5 = new Rooms("\"Creek\" " , "\n" +
                "I stumble upon a babbling creek, its waters crystal clear and inviting. \n" +
                "Shadows dance along the banks, hinting at the presence of unseen predators waiting to strike. \n", 8);

        Rooms room6 = new Rooms("\"Sprawling City\" " , "\n" +
                "its towering structures reaching towards the heavens. \n" +
                "The streets bustle with activity, yet there's an undercurrent of darkness beneath the facade of civilization. \n" +
                "With each step, I'm drawn deeper into the heart of the city.", 13);

        Rooms room7 = new Rooms("\"Castle\" " , "\n" +
                "I behold the looming silhouette of a decrepit castle, its crumbling towers a testament to ages long past. \n" +
                "Yet, despite its dilapidated state, there's an undeniable sense of power that emanates from its ancient stones. \n" +
                "With each step, I can feel the weight of history pressing down upon me, urging me onwards towards an uncertain destiny.", 16);

        Rooms room8 = new Rooms("\"Basement\" " , "\n" +
                "its walls lined with forgotten relics of a bygone era. Dust hangs heavy in the air, shrouding the room in an oppressive silence. \n" +
                "As I explore further, I can't shake the feeling of being watched, \n" +
                "as if the very walls themselves hold the secrets of untold horrors waiting to be unleashed.", 14);

        Rooms room9 = new Rooms("\"Catacombs\" " , "\n" +
                "I find myself in the shadowy embrace of the catacombs, its twisting corridors lined with the bones of the long-dead. \n" +
                "The air grows thick with the scent of decay, as if the very walls themselves mourn the passing of those who came before. \n", 13);

        room1.setEastConnection(room2);
        room1.setSouthConnection(room4);

        room2.setEastConnection(room3);
        room2.setWestConnection(room1);

        room2.setIsEastLocked(true);

        room3.setSouthConnection(room6);
        room3.setWestConnection(room2);

        room4.setNorthConnection(room1);
        room4.setSouthConnection(room7);

        room5.setSouthConnection(room8);

        room6.setSouthConnection(room9);
        room6.setNorthConnection(room3);

        room7.setNorthConnection(room4);
        room7.setEastConnection(room8);

        room8.setNorthConnection(room5);
        room8.setEastConnection(room9);
        room8.setWestConnection(room7);

        room9.setNorthConnection(room6);
        room9.setWestConnection(room8);
        currentRoom = room1;

        Items item1 = new Items("Rusty Sword", "About as sharp as a butter knife");
        Items item2 = new Items("Moonlight Lantern", "Shines brighter than a thousand suns");
        Food apple = new Food("Apple", "A red apple", 10);
        Food banana = new Food("Banana", "a yellow banana", 20);
        Food bigMac = new Food("Green pill", "I wonder what this does...", -10);
        Weapon sword = new MeleeWeapons("Iron Sword", "A rusty iron sword", 2, 6, 20);
        Weapon bow = new RangedWeapons("Longbow", "looks ancient", 2, 6, 20);
        Items key = new Items("Golden key", "A shiny golden key - might unlock something");
        Weapon smallKnife = new MeleeWeapons("Small knife:", "A small knife", 1, 6, 20);
        Enemy goblin = new Enemy(10, 12, 12, 4, 5, 5, 50, "Goblin:", "A foul creature", smallKnife, room2, 12);

        Weapon ashbringer = new MeleeWeapons("Ashbringer", "Blade of the High Lord", 2, 12, 100);
        Items goldenCrown = new Items("Golden Crown", "The jewels on this crown seems expensive");


        Music soundOne = new Music("music" + File.separatorChar + "Undertale OST 023 - Shop.wav", room1, "Shop");
        Music soundTwo = new Music("music" + File.separatorChar + "sampleOne.wav", room2, "San II");
        Music soundThree = new Music("music" + File.separatorChar + "megalovia.wav", room3, "Megalovia");
        Music soundFour = new Music("music" + File.separatorChar + "Undertale OST 001 - Once Upon A Time.wav", room4, "Once Upon A Time");
        Music soundFive = new Music("music" + File.separatorChar + "rollespil.wav", room5, "Rollespil");
        Music soundSix = new Music("music" + File.separatorChar + "Nintendo Wii - Mii Channel Theme.wav", room6, "Wii Theme");
        Music soundSeven = new Music("music" + File.separatorChar + "The Imperial March.wav", room7, "March");
        Music soundEight = new Music("music" + File.separatorChar + "Super Mario Bros. Theme Song.wav", room8, "Mario");
        Music soundNine = new Music("music" + File.separatorChar + "Pirates Of The Caribbean Theme Song.wav", room9, "Pirates");


        room1.addItemToRoom(sword);
        room1.addItemToRoom(bow);

        room4.addItemToRoom(apple);
        room4.addItemToRoom(banana);
        room4.addItemToRoom(bigMac);

        room1.addItemToRoom(key);

        room2.addEnemyToRoom(goblin);

        room3.addItemToRoom(item1);
        room6.addItemToRoom(item2);

        room1.addMusic(soundOne);
        room2.addMusic(soundTwo);
        room3.addMusic(soundThree);
        room4.addMusic(soundFour);
        room5.addMusic(soundFive);
        room6.addMusic(soundSix);
        room7.addMusic(soundSeven);
        room8.addMusic(soundEight);
        room9.addMusic(soundNine);

        room4.addHiddenItemToRoom(ashbringer);
        room2.addHiddenItemToRoom(goldenCrown);






    }

    public Rooms getStartRoom(){
        return currentRoom;
    }


}
