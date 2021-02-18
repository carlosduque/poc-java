package o.oo.vo;

public class Word {
    private String content;
    
    public Word() {}
    
    public Word(String newContent) {
        this.content = newContent;
    }
    
    public String getContent() {
        return this.content;
    }
    public void setContent(String content) {
        this.content = content;
    }

    @Override
   public String toString() {
       return this.content;
   } 
        
}