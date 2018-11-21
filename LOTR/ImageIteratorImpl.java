import greenfoot.*;
import java.util.List;
/**
 * Write a description of class ImageIteratorImpl here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ImageIteratorImpl  implements IImageIterator
{
    private List<GifImage> explosionImages;
    private int cursor=0;
    
    public ImageIteratorImpl(List<GifImage> explosionImages){
        this.explosionImages = explosionImages;
    }
    
    public boolean hasNext(){
        // if list has element it will always loop through it, since its a circular list.
        return explosionImages!=null && !explosionImages.isEmpty();
    }
    
    public void moveToNext(){
        if(explosionImages == null){
            return;
        }
        cursor = (cursor +1)%explosionImages.size();
    }
    
    public GifImage currentImage(){
        if(explosionImages==null){
            return null;
        }
        return explosionImages.get(cursor);
    }
}
