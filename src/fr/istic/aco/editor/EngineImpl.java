package fr.istic.aco.editor;

import java.util.Scanner;
import java.util.Iterator;

public class EngineImpl implements Engine {
    private String buffer;
    private String clipBoard;
    private Selection selection;

    public EngineImpl(){
        buffer="";
        clipBoard="";
        selection= new SelectionImpl();
        selection.setEngine(this);
    }

    public void setClipBoard(String texte){
        this.clipBoard= texte;
    }

    /**
     * Provides access to the selection control object
     *
     * @return the selection object (to review !!)
     */
    @Override
    public Selection getSelection() {
            return this.selection;
    }

    /**
     * Provides the whole contents of the buffer, as a string
     *
     * @return a copy of the buffer's contents
     */
    @Override
    public String getBufferContents() {
        return this.buffer;
    }

    /**
     * Provides the clipboard contents
     *
     * @return a copy of the clipboard's contents
     */
    @Override
    public String getClipboardContents() {
        return this.clipBoard;
    }

    /**
     * Removes the text within the interval
     * specified by the selection control object,
     * from the buffer.
     */
    @Override
    public void cutSelectedText() {
        StringBuffer buffer= new StringBuffer();
        buffer.append(this.getBufferContents());
        buffer.replace(this.getSelection().getBeginIndex(),this.getSelection().getEndIndex(),"");
        this.setBufferContains(buffer.toString());
    }

    /**
     * Copies the text within the interval
     * specified by the selection control object
     * into the clipboard.
     */
    @Override
    public void copySelectedText() {

        StringBuffer clipBoard= new StringBuffer();
        clipBoard.append(this.getBufferContents());
        int indexDebutSelection= this.getSelection().getBeginIndex();
        int indexFinSelection= this.getSelection().getEndIndex();
        StringBuffer copie= new StringBuffer();

        for(int i=indexDebutSelection;i<indexFinSelection;i++){
            copie.append(clipBoard.toString().charAt(i));
        }

        this.setClipBoardContains(copie.toString());
        return ;
    }

    /**
     * Replaces the text within the interval specified by the selection object with
     * the contents of the clipboard.
     */
    @Override
    public void pasteClipboard() {
        StringBuffer clipBoard= new StringBuffer();
        clipBoard.append(this.getClipboardContents());
        this.setClipBoardContains(clipBoard.toString());
        this.getSelection().setBeginIndex(0);
        this.getSelection().setEndIndex(this.getClipboardContents().length()-1);
        this.getSelection().setEngine(this);
        return ;
    }

    /**
     * Inserts a string in the buffer, which replaces the contents of the selection
     *
     * @param s the text to insert
     */
    @Override
    public void insert(String s) {
        StringBuffer buffer= new StringBuffer();
        buffer.append(this.getBufferContents());
        buffer.replace(this.getSelection().getBeginIndex(),this.getSelection().getEndIndex(),s);
        this.setBufferContains(buffer.toString());
        return ;
    }

    /**
     * Removes the contents of the selection in the buffer
     */
    @Override
    public void delete() {
       StringBuffer buffer= new StringBuffer();
       buffer.append(this.getBufferContents());
       buffer.delete(this.getSelection().getBeginIndex(),this.getSelection().getEndIndex());
       this.setBufferContains(buffer.toString());
       return ;
    }

    @Override
    public void setBufferContains(String texte){
        this.buffer=texte;
    }

    @Override
    public void setClipBoardContains(String texte){
        this.clipBoard=texte;
    }

    @Override
    public void setSelection(int beginIndex,int endIndex){
        selection.setBeginIndex(beginIndex);
        selection.setEndIndex(endIndex);
    }

}
