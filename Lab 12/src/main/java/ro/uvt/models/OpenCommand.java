package ro.uvt.models;

public class OpenCommand implements Command{
    String file;

    public OpenCommand(String file) {
        this.file = file;
    }

    @Override
    public void execute() {

    }
}
