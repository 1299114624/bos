package com.archforce.bos.identity.utils;

import com.google.code.kaptcha.NoiseProducer;
import com.google.code.kaptcha.util.Configurable;

import java.awt.*;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * 验证码干扰线
 */
public class Noise extends Configurable implements NoiseProducer {

    @Override
    public void makeNoise(BufferedImage image, float factorOne, float factorTwo, float factorThree, float factorFour) {
        Color color = getConfig().getNoiseColor();
        // image size
        int width = image.getWidth();
        int height = image.getHeight();

        // the points where the line changes the stroke and direction
        Point2D[] pts = null;
        Random rand = new Random();

        // the curve from where the points are taken
        CubicCurve2D cc = new CubicCurve2D.Float(width*factorOne, height
            * rand.nextFloat(),width*factorTwo,    height
            * rand.nextFloat(),width*factorThree,    height
            * rand.nextFloat(), width*factorFour,    height
            * rand.nextFloat());

        // creates an iterator to define the boundary of the flattened curve
        PathIterator pi = cc.getPathIterator(null, 2);
        Point2D[] tmp = new Point2D[200];
        int i = 0;

        // while p1 is iterating the curve, adds points to tmp array
        while (!pi.isDone()) {
            float[] coords = new float[6];
            switch (pi.currentSegment(coords)) {
                case PathIterator.SEG_MOVETO:
                case PathIterator.SEG_LINETO:
                case PathIterator.SEG_CUBICTO:
                case PathIterator.SEG_QUADTO:
                    tmp[i] = new Point2D.Float(coords[0], coords[1]);
            }
            i++;
            pi.next();
        }

        pts = new Point2D[i];
        System.arraycopy(tmp, 0, pts, 0, i);
        Graphics2D graph = (Graphics2D) image.getGraphics();
        graph.setRenderingHints(new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON
        ));
        graph.setColor(color);

        // for the maximum 3 point change the stroke and direction
        for (i = 0; i < 10; i++) {
            int xs = rand.nextInt(width);
            int ys = rand.nextInt(height);
            int xe = xs + rand.nextInt(width / 8);
            int ye = ys + rand.nextInt(height / 8);
            graph.setColor(getColor());
            graph.drawLine(xs, ys, xe, ye);
        }
        graph.dispose();
    }

    private Color getColor() {
        Random random = new Random();
        int red = random.nextInt(255);
        int green = random.nextInt(255);
        int blue = random.nextInt(255);
        return new Color(red, green, blue);
    }
}
