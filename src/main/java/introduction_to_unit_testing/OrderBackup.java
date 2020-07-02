package introduction_to_unit_testing;

import java.io.*;
import java.util.WeakHashMap;

public class OrderBackup {

    private Writer writer;

    void createFile() throws FileNotFoundException {
        File file = new File("orderBackup.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
        writer = new BufferedWriter(outputStreamWriter);
    }

    void closedFile() throws  IOException {
        writer.close();
    }

    void backOrder(Order order) throws IOException {
        writer.append(order.toString());
    }

    public Writer getWriter() {
        return writer;
    }
}
