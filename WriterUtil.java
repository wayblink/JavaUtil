import java.io.*;

public class WriterUtil{

    public void writeByFileOutputStream() {

        FileOutputStream fop = null;
        File file;
        String content = "This is the text content";
        try {
            file = new File("c:/newfile.txt");
            fop = new FileOutputStream(file);
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            // get the content in bytes
            byte[] contentInBytes = content.getBytes();

            fop.write(contentInBytes);
            fop.flush();
            fop.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void writeByFileReader() {
        try {
            String data = " This content will append to the end of the file";

            File file = new File("javaio-appendfile.txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }

            // true = append file
            FileWriter fileWritter = new FileWriter(file.getName(), true);
            fileWritter.write(data);
            fileWritter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeByBufferedReader() {
        try {

            String content = "This is the content to write into file";
            File file = new File("/users/mkyong/filename.txt");
            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }
            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.flush();
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
