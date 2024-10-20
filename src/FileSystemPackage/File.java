package FileSystemPackage;

public class File implements FileSystem {
    public String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void ls(String path) {
        System.out.println(path+name);
    }
}
