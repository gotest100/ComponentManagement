package masterSpringMvc.services;

public class GreetModel {
    private final long id;
    private final String content;

    public GreetModel(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

}
