package coding.oop.filesystem;

public class File extends Item{

    private String content;
    private int size;

    public File(String name, Directory parent) {
        super(name, parent);
    }

    @Override
    public long size() {
        return size;
    }

    protected void setSize(final int size) {
        this.size = size;
    }

    public void setContent(final String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
