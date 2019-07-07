package services.fg.reader;

import java.io.*;

public class FilePageReader implements PageReader {

    private String path;
    private File file;

    public FilePageReader(String path){
        this.path = path;
    }

    public FilePageReader(File file){
        this.file = file;
    }

    @Override
    public void read(int seek, int chars) {

        if (this.file == null){
            this.file = new File(this.path);
        }

        try(RandomAccessFile raf = new RandomAccessFile(this.file, "r")){
            raf.seek(seek);
            byte[] bytes = new byte[chars];
            raf.read(bytes);

            BufferedReader isr = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes), "UTF-8"));
            String str = null;
            while ((str = isr.readLine()) != null){
                System.out.println(str);
            }
       }catch (IOException ex){
            System.out.println("Не удалось прочиттать файл: "+ex);
        }

    }
}
