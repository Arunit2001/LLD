package FileSystemPackage;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    public String name;
    public List<FileSystem> list;
    public Directory(String name) {
        this.name = name;
        list = new ArrayList<>();
    }
    public void addToDirectory(FileSystem file) {
        list.add(file);
    }
    @Override
    public void ls(String path) {
        path += (name+"/");
        for(FileSystem file : list) {
            file.ls(path);
        }
    }
}
