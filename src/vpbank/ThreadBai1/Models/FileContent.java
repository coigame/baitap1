package vpbank.ThreadBai1.Models;

import java.io.File;
import java.net.URI;
import java.util.LinkedList;
import java.util.Queue;

public class FileContent extends File {
    private Queue<String> content = new LinkedList<>();
    public FileContent(String pathname) {
        super(pathname);
    }

    public FileContent(String parent, String child) {
        super(parent, child);
    }

    public FileContent(File parent, String child) {
        super(parent, child);
    }

    public FileContent(URI uri) {
        super(uri);
    }

    public FileContent(String pathname, Queue<String> content) {
        super(pathname);
        this.content = content;
    }

    public FileContent(String parent, String child, Queue<String> content) {
        super(parent, child);
        this.content = content;
    }

    public FileContent(File parent, String child, Queue<String> content) {
        super(parent, child);
        this.content = content;
    }

    public FileContent(URI uri, Queue<String> content) {
        super(uri);
        this.content = content;
    }

    public Queue<String> getContent() {
        return content;
    }

    public void setContent(Queue<String> content) {
        this.content = content;
    }
}
