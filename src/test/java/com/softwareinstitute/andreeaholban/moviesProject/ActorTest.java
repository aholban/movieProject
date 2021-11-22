package com.softwareinstitute.andreeaholban.moviesProject;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ActorTest {

    @Test
    void testSetID(){
        Actor actor = new Actor("Tom", "Holland");
        actor.setActor_id(300);
        assertEquals(300, actor.getActor_id(), "Set wrong actor ID");
    }

    @Test
    void testGetName(){
        Actor actor = new Actor("Tom", "Holland");
        String name = actor.getFirstName() + " " + actor.getLastName();
        assertEquals("Tom Holland", name, "Wrong actor name");
    }

    @Test
    void testSetName(){
        Actor actor = new Actor();
        actor.setFirstName("Tom");
        actor.setLastName("Holland");
        String name = actor.getFirstName() + " " + actor.getLastName();
        assertEquals("Tom Holland", name, "Set wrong actor name");
    }
}
