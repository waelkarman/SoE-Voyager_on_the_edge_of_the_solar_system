/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SoEproj;

import java.awt.Rectangle;
import java.awt.Image;
import javax.swing.ImageIcon;

// The term sprite has several meanings. It is used to denote an image or an 
// animation in a scene.

public class Sprite {

    protected int x;
    protected int y;
    protected int width;
    protected int height;
    protected boolean visible;
    protected boolean dying; 
    protected Image image;
    protected float SPACE;

    public Sprite(int x, int y) {
        this.x = x;
        this.y = y;
        visible = true;
    }

    protected void getImageDimensions() {
        width = image.getWidth(null);
        height = image.getHeight(null);
    }

    protected void loadImage(String imageName) {
        ImageIcon ii = new ImageIcon(imageName);
        image = ii.getImage();
    }

    public Image getImage() {
        return image;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getIsDying() {
        return dying;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setDying(boolean dying) {
        this.dying = dying;
    }

    // returns the bounding rectangle of the sprite image
    public Rectangle getBounds() {
        return new Rectangle(x, y, width, height);
    }

    public void die() {    
        visible = false;
    }

    public void setImage(Image image) {   
        this.image = image;
    }

    public boolean isDying() {   
        return this.dying;
    }
}