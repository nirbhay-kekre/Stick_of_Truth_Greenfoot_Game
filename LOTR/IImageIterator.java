import greenfoot.*;
/**
 * Write a description of class IImageIterator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface IImageIterator  
{
    public boolean hasNext();
    public void moveToNext();
    public GifImage currentImage();
}
