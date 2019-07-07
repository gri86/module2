package services.fg.reader;

import java.io.File;

public class Navigation {

    File file;
    int start;
    int end;
    long fileSize;
    PageReader pageReader;
    int pageSize;

    public Navigation(File file, int pageSize){
        start = 1;
        this.file = file;
        fileSize = this.file.length();
        this.pageReader = new FilePageReader(file);
        this.pageSize = pageSize;
        end = (int) (this.fileSize/this.pageSize);

    }



    public void forwrard(){
        pageReader.read(start-1, pageSize);
        start+=pageSize;
    }

    public void back(){
        pageReader.read(start-1, pageSize);
        start-=pageSize;
    }
}
