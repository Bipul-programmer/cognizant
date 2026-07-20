public class ImageViewerTest {
    public static void main(String[] args) {
        Image photo1 = new ProxyImage("sunset.jpg");
        Image photo2 = new ProxyImage("mountains.jpg");

        System.out.println("First display of sunset.jpg:");
        photo1.display();

        System.out.println();
        System.out.println("First display of mountains.jpg:");
        photo2.display();

        System.out.println();
        System.out.println("Second display of sunset.jpg (should be cached):");
        photo1.display();
    }
}
