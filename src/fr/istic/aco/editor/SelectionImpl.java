package fr.istic.aco.editor;

public class SelectionImpl implements Selection {
    private Engine engine;
    private int beginIndex;
    private int endIndex;
    private int bufferBeginIndex;
    private int bufferEndIndex;

    public SelectionImpl(){
        beginIndex=0;
        endIndex=0;
    }

    @Override
    public int getBeginIndex() {
        return this.beginIndex;
    }

    @Override
    public int getEndIndex() {
        return this.endIndex;
    }

    @Override
    public int getBufferBeginIndex() {
        if(engine.getBufferContents().length()==0){
            bufferBeginIndex=0;
        }else{
            bufferBeginIndex=1;
        }
          return  bufferBeginIndex;
    }

    @Override
    public int getBufferEndIndex() {
        bufferEndIndex=engine.getBufferContents().length()-1;;
        if(engine.getBufferContents().length()==0){
            bufferEndIndex=0;
        }
        return bufferEndIndex;
    }

    @Override
    public void setBeginIndex(int beginIndex) {
        this.beginIndex=beginIndex;
    }

    @Override
    public void setEndIndex(int endIndex) {
        this.endIndex=endIndex;
    }

    @Override
    public void setEngine(Engine engine) {
        this.engine=engine;
    }

}
