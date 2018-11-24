import greenfoot.GreenfootImage;
import java.util.List;
import java.util.ArrayList;

/**
 * Write a description of class CircularImageRepository here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageRepository  implements IIterableImageRepository
{
    List<GifImage> explosionImages ;
    IImageIterator iterator ;
    private static ImageRepository repository;
    
    public static synchronized ImageRepository getImageRepository(){
        if(repository ==null){
            repository = new ImageRepository();
        }
        return repository;
    }
    
    private ImageRepository(){
        explosionImages = new ArrayList<GifImage>();
        explosionImages.add(new GifImage("explosion1.gif"));
        explosionImages.add(new GifImage("explosion2.gif"));
        explosionImages.add(new GifImage("explosion3.gif"));
        explosionImages.add(new GifImage("explosion4.gif"));
        explosionImages.add(new GifImage("explosion5.gif"));
        iterator = new ImageIteratorImpl(explosionImages);
    }
    
    public IImageIterator getImgageIterator(){
        return iterator;
    }
}
