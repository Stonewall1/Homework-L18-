package XMLTask;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private List<String> line = new ArrayList<>();

    public List<String> getLine() {
        return line;
    }

    public void setLine(List<String> line) {
        this.line = line;
    }

    @Override
    public String toString() {
        return "Line{" +
                "line=" + line +
                '}';
    }
}
