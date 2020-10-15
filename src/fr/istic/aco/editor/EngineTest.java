package fr.istic.aco.editor;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EngineTest {

    private Engine engine;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        engine = new EngineImpl();
    }

    private void todo() {
        fail("Unimplemented test");
    }
    @Test
    @DisplayName("Buffer must be empty after initialisation")
    void getSelection() {
        Selection selection =  engine.getSelection();
        assertTrue(selection.getBeginIndex()==0);
        assertTrue(selection.getEndIndex()==0);
        assertEquals(selection.getBufferBeginIndex(),selection.getBeginIndex());
        assertEquals("",engine.getBufferContents());
    }

    @Test
    void getBufferContents() {
        engine.setBufferContains("Bienvenue");
        assertFalse(engine.getBufferContents().equals("Bien"));
        assertTrue(engine.getBufferContents().equals("Bienvenue"));
    }

    @Test
    void getClipboardContents() {
        engine.setClipBoardContains("à la maison");
        assertFalse(engine.getClipboardContents().equals("maison"));
        assertFalse(engine.getClipboardContents().equals("a la maison"));
        assertTrue(engine.getClipboardContents().equals("à la maison"));
    }

    @Test
    void cutSelectedText() {
        engine.setBufferContains("Bienvenue");
        engine.setSelection(0,4);
        engine.cutSelectedText();
        assertTrue(engine.getBufferContents().equals("venue"));
    }

    @Test
    void copySelectedText() {
        engine.setBufferContains("Bienvenue");
        engine.setSelection(0,4);
        engine.copySelectedText();
        assertTrue(engine.getClipboardContents().equals("Bien"));
    }

    @Test
    void pasteClipboard() {
        engine.setClipBoardContains("Helloo ça va ?");
        engine.pasteClipboard();
        assertEquals(engine.getClipboardContents().length()-1,engine.getSelection().getEndIndex());
    }

    @Test
    void insert(){
        engine.setBufferContains("selection loading");
        engine.setSelection(0,3);
        engine.insert("s");
        assertTrue(engine.getBufferContents().equals("section loading"));
    }
}
