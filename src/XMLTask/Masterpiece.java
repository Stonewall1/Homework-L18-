package XMLTask;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "sonnet")
@XmlAccessorType(XmlAccessType.FIELD)
public class Masterpiece {
    @XmlAttribute(name = "type", required = true)
    private String type;
    private Author author;
    private String title;
    private Line lines;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public Line getLines() {
        return lines;
    }

    public void setLines(Line lines) {
        this.lines = lines;

    }

    @Override
    public String toString() {
        return "Masterpiece{" +
                "type='" + type + '\'' +
                ", author=" + author +
                ", title='" + title + '\'' +
                ", lines=" + lines +
                '}';
    }
}
