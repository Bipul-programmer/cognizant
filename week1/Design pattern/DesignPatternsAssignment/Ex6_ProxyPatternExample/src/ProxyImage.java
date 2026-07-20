import java.util.HashMap;
import java.util.Map;

public class ProxyImage implements Image {
    private final String fileName;

    
    
    private static final Map<String, RealImage> cache = new HashMap<>();

    public ProxyImage(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void display() {
        RealImage realImage = cache.get(fileName);
        if (realImage == null) {
            System.out.println("Cache miss for \"" + fileName + "\".");
            realImage = new RealImage(fileName);
            cache.put(fileName, realImage);
        } else {
            System.out.println("Cache hit for \"" + fileName + "\" -- skipping remote load.");
        }
        realImage.display();
    }
}
