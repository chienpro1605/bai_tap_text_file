package copyfiletext;

import java.io.*;

public class CoppyFileText {
    public static void main(String[] args) throws IOException {
        File source = new File("chien.txt");
        File dest = new File("tes123.txt");

        InputStream is = null;
        OutputStream os = null;

        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);

            byte[] buffer = new byte[1024];
            int length;

            while ((length = is.read(buffer))>0){
                os.write(buffer,0,length);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (is!=null){
                is.close();
            }
            if (os!=null){
                os.close();
            }
        }
    }
}
