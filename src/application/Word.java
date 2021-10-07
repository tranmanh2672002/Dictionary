package application;

public class Word {
    private String word_target;
    private String word_explain;

    public Word() {
        this.word_target = "target";
        this.word_explain = "explain";
    }
    public Word(String target, String explain) {
        this.word_target = target;
        this.word_explain = explain;
    }
    public void setWordTarget(String word) {
        this.word_target = word;
    }
    public void setWordExplain(String word) {
        this.word_explain = word;
    }
    public String getWordTarget() {
        return this.word_target;
    }
    public String getWordExplain() {
        return this.word_explain;
    }
}

