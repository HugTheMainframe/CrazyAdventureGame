import java.util.ArrayList;

public class Maps {
    private Rooms currentRoom;


    public Maps() {
        buildMap();

    }

    public void buildMap() {
       Rooms room1 = new Rooms("\"Dungeon\": ", "Entering the dungeon, the air grows heavy with the stench of decay.\n" +
                "Torches flicker dimly, casting eerie shadows on the cold stone walls.\n" +
                "I can hear the distant echoes of tortured souls, imprisoned within its depths.\n" +
                "As I press forward, the feeling of foreboding intensifies, as if unseen eyes are watching my every move.\n" +
                "Deeper into the darkness, I tread cautiously, knowing that only the bravest dare to face the horrors lurking within.");
        Rooms room2 = new Rooms("\"Prison\": " , "Emerging from the dungeon's depths, I find myself in a desolate prison,\n" +
                "its walls lined with rusted iron bars. The echoes of suffering linger here, trapped within the confines of forgotten cells.\n" +
                "Each step reverberates with the weight of the past, as if the very stones themselves bear witness to the anguish endured.\n" +
                "As I explore further, I can't shake the feeling of being watched, as if the spirits of the damned still haunt these forsaken halls.");
        Rooms room3 = new Rooms("\"Cave\": " , "Venturing beyond the prison's confines, \n" +
                "I find solace in the natural sanctuary of a dark, echoing cave. \n" +
                "The damp earth beneath my feet whispers tales of ancient secrets hidden within its depths. \n" +
                "Shadows dance along the walls, hinting at unseen dangers lurking just out of sight. \n" +
                "Yet, amidst the darkness, there is a sense of tranquility, a respite from the horrors that lie above. \n" +
                "With cautious steps, I delve deeper into the unknown, drawn by the promise of discovery.");
        Rooms room4 = new Rooms("\"Forest\": " , "Emerging from the dungeon's embrace, \n" +
                "I find myself amidst the dense foliage of an ancient forest. \n" +
                "Towering trees loom overhead, their branches intertwined like gnarled fingers reaching towards the sky. \n" +
                "Yet, amidst the tranquility of nature, there is a sense of unease, as if unseen eyes watch my every move from the shadows. \n" +
                "With each step, I can't shake the feeling that I am being drawn towards a darker purpose, \n" +
                "a destiny intertwined with the very heart of the forest itself.");
        Rooms room5 = new Rooms("\"Creek\": " , "Following the winding path through the basement, \n" +
                "I stumble upon a babbling creek, its waters crystal clear and inviting. \n" +
                "Yet, beneath the surface lies a hidden danger, lurking in the depths below. \n" +
                "Shadows dance along the banks, hinting at the presence of unseen predators waiting to strike. \n" +
                "Despite the tranquil facade, I know that danger lurks just beneath the surface, \n" +
                "ready to ensnare the unwary traveler in its watery embrace.");
        Rooms room6 = new Rooms("\"Sprawling City\": " , "Exiting the cave, I arrive at the outskirts of a sprawling city, \n" +
                "its towering structures reaching towards the heavens. \n" +
                "The streets bustle with activity, yet there's an undercurrent of darkness beneath the facade of civilization. \n" +
                "Shadows lurk in every alleyway, whispers of secrets and mysteries hiding within the labyrinthine streets. \n" +
                "With each step, I'm drawn deeper into the heart of the city, where untold dangers await those who dare to uncover its secrets.");
        Rooms room7 = new Rooms("\"Castle\": " , "Approaching the city's center, \n" +
                "I behold the looming silhouette of a decrepit castle, its crumbling towers a testament to ages long past. \n" +
                "Yet, despite its dilapidated state, there's an undeniable sense of power that emanates from its ancient stones. \n" +
                "As I approach, I can't shake the feeling of being drawn towards its dark embrace, \n" +
                "as if fate itself beckons me to uncover the secrets hidden within its labyrinthine halls. \n" +
                "With each step, I can feel the weight of history pressing down upon me, urging me onwards towards an uncertain destiny.");
        Rooms room8 = new Rooms("\"Basement\": " , "Descending into the depths of the castle, I find myself in a dimly lit basement, \n" +
                "its walls lined with forgotten relics of a bygone era. Dust hangs heavy in the air, shrouding the room in an oppressive silence. \n" +
                "Yet, amidst the darkness, there is a sense of urgency, as if time itself is running out. \n" +
                "As I explore further, I can't shake the feeling of being watched, \n" +
                "as if the very walls themselves hold the secrets of untold horrors waiting to be unleashed.");
        Rooms room9 = new Rooms("\"Catacombs\": " , "Delving deeper into the bowels of the castle, \n" +
                "I find myself in the shadowy embrace of the catacombs, its twisting corridors lined with the bones of the long-dead. \n" +
                "The air grows thick with the scent of decay, as if the very walls themselves mourn the passing of those who came before. \n" +
                "Yet, amidst the darkness, there is a sense of purpose, \n" +
                "a calling that urges me ever onwards towards the heart of the labyrinth. With each step, \n" +
                "I can feel the weight of destiny pressing down upon me, as if the very fabric of reality hangs in the balance.");

        room1.setEastConnection(room2);
        room1.setSouthConnection(room4);

        room2.setEastConnection(room3);
        room2.setWestConnection(room1);

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

        room3.addItemToRoom(item1);
        room6.addItemToRoom(item2);

    }

    public Rooms getStartRoom(){
        return currentRoom;
    }


}
