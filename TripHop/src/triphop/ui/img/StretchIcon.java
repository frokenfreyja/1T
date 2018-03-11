/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package triphop.ui.img;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;
import java.awt.image.ImageObserver;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 * An <CODE>Icon</CODE> that scales its image to fill the component area,
 * excluding any border or insets, optionally maintaining the image's aspect
 * ratio by padding and centering the scaled image horizontally or vertically.
 * <P>
 * The class is a drop-in replacement for <CODE>ImageIcon</CODE>, except that
 * the no-argument constructor is not supported.
 * <P>
 * As the size of the Icon is determined by the size of the component in which
 * it is displayed, <CODE>StretchIcon</CODE> must only be used in conjunction
 * with a component and layout that does not depend on the size of the
 * component's Icon.
 * 
 * @version 1.0 03/27/12
 * @author Darryl
 */
public class StretchIcon extends ImageIcon {

  /**
   * Determines whether the aspect ratio of the image is maintained.
   * Set to <code>false</code> to allow th image to distort to fill the component.
   */
  protected boolean proportionate = false;
  
  /**
   * Creates a <CODE>StretchIcon</CODE> from the specified URL.
   *
   * @param location the URL for the image
   *
   * @see ImageIcon#ImageIcon(java.net.URL)
   */
  public StretchIcon(URL location) {
    super(location);
  }

  /**
   * Paints the icon.  The image is reduced or magnified to fit the component to which
   * it is painted.
   * <P>
   * If the proportion has not been specified, or has been specified as <code>true</code>,
   * the aspect ratio of the image will be preserved by padding and centering the image
   * horizontally or vertically.  Otherwise the image may be distorted to fill the
   * component it is painted to.
   * <P>
   * If this icon has no image observer,this method uses the <code>c</code> component
   * as the observer.
   *
   * @param c the component to which the Icon is painted.  This is used as the
   *          observer if this icon has no image observer
   * @param g the graphics context
   * @param x not used.
   * @param y not used.
   *
   * @see ImageIcon#paintIcon(java.awt.Component, java.awt.Graphics, int, int)
   */
  @Override
  public synchronized void paintIcon(Component c, Graphics g, int x, int y) {
    Image image = getImage();
    if (image == null) {
      return;
    }
    Insets insets = ((Container) c).getInsets();
    x = 3;
    y = 3;

    int w = c.getWidth() - x - 3;
    int h = c.getHeight() - y - 3;

    if (proportionate) {
      int iw = image.getWidth(c);
      int ih = image.getHeight(c);

      if (iw * h < ih * w) {
        iw = (h * iw) / ih;
        x += (w - iw) / 2;
        w = iw;
      } else {
        ih = (w * ih) / iw;
        y += (h - ih) / 2;
        h = ih;
      }
    }

    ImageObserver io = getImageObserver();
    g.drawImage(image, x, y, w, h, io == null ? c : io);
  }

  /**
   * Overridden to return 0.  The size of this Icon is determined by
   * the size of the component.
   * 
   * @return 0
   */
  @Override
  public int getIconWidth() {
    return 0;
  }

  /**
   * Overridden to return 0.  The size of this Icon is determined by
   * the size of the component.
   *
   * @return 0
   */
  @Override
  public int getIconHeight() {
    return 0;
  }
}
