/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

import static javax.swing.text.StyleConstants.Size;
import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 *
 * @author BRANDON
 */
public class Dados {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     Mat source =  Imgcodecs.imread("C:\\Users\\BRANDON\\Desktop\\BDN\\dados_img_proc\\d4.png");
     Mat destination = new Mat();
     Mat destination2 = new Mat();
     destination = source.clone();
     Mat th = new Mat();
     Mat te = new Mat();
     
     int erosion_size = 2;
     int dilation_size =2;
     Mat dst = new Mat(), cdst = new Mat();
     
     Imgproc.GaussianBlur(source, destination,new Size(25,25), 0);
     Imgproc.threshold(destination, dst,100,255, Imgproc.THRESH_TOZERO);
     
     
     Mat element = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2*erosion_size + 1, 2*erosion_size+1));
     Imgproc.erode(dst, cdst, element);
     
     Mat element1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2*dilation_size + 1, 2*dilation_size+1));
     Imgproc.dilate(cdst, th, element1);
     
        for (int i = 0; i < th.rows(); i++) {
            for (int j = 0; j < th.cols(); j++) {
                if (th.get(i, j)[0]==255) {
                    
                }
            }
        }
     
     dst = th.clone();
     //Imgproc.Canny(th, destination2, 150, 100, 3,false); 
     //Imgproc.HoughLinesP(destination2, te, 1, Math.PI / 180, 50,50,10); 
     
    //  Imgproc.HoughLinesP(dst, linesP, 1, Math.PI / 180, 50, 50, 10);
/*
     Mat element1 = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(2*dilation_size + 1, 2*dilation_size+1));
     Imgproc.dilate(destination, destination2, element1);*/
     
           // Declare the output variables

        /*Mat src = Imgcodecs.imread("C:\\Users\\laboratorios\\Desktop\\IMGS\\dados_img_proc\\d5.png", Imgcodecs.IMREAD_GRAYSCALE);
        if (src.empty()) {
            System.out.println("Error opening image!");
            System.out.println("Program Arguments: [image_name -- default "
                    + source + "] \n");
            System.exit(-1);
        }*/
        /*Imgproc.HoughLines(src, dst, 1, Math.PI / 180, 2); 
                Mat lines = new Mat();
        Imgproc.Canny(dst, lines, 150, 200, 3, false);*/
       /* Imgproc.Canny(source, dst, 150, 200, 3,false); 
        Imgproc.cvtColor(dst, cdst, Imgproc.COLOR_GRAY2BGR);
                Mat lines = new Mat();*/
         //Imgproc.threshold(cdst, lines,160,255, Imgproc.THRESH_BINARY+Imgproc.THRESH_OTSU); 

       // Imgproc.HoughLines(cdst, lines, 1, Math.PI / 180, 2); 
      // Imgproc.cvtColor(dst, cdst, Imgproc.COLOR_GRAY2BGR);
        // Standard Hough Line Transform // will hold the results of the detection// runs the actual detection
        

        /*Mat element = Imgproc.getStructuringElement(Imgproc.THRESH_BINARY_INV, new Size(erosion_size, erosion_size));
        Imgproc.erode(cdst, destination, element);*/
        // Draw the lines
        /* double[] m = new double[lines.rows()];
        double[] bm = new double[lines.rows()];
        for (int x = 0; x < lines.rows(); x++) {
            double rho = lines.get(x, 0)[0],
                    theta = lines.get(x, 0)[1];
            double a = Math.cos(theta), b = Math.sin(theta);
            double x0 = a * rho, y0 = b * rho;
            m[x]=-(a/b);
            bm[x]= rho/b;
            Point pt1 = new Point(Math.round(x0 + 1000 * (-b)), Math.round(y0 + 1000 * (a)));
            Point pt2 = new Point(Math.round(x0 - 1000 * (-b)), Math.round(y0 - 1000 * (a)));
            Imgproc.line(cdst, pt1, pt2, new Scalar(0, 0, 255), 3, Imgproc.LINE_AA, 0);
        }
        System.out.println(m.length);
        double[] p = new double[lines.rows()];
        for (int i = 0; i < m.length; i++) {
            if (i==m.length) {
                ///GAUS , THRESHOLD OTSU
            }else{
            p[i]=(bm[i]-bm[i+1])/(m[i+1]-m[i]);
            }
            
        }
        // Probabilistic Line Transform
        Mat linesP = new Mat(); // will hold the results of the detection
        Imgproc.HoughLinesP(dst, linesP, 1, Math.PI / 180, 50, 50, 10); // runs the actual detection
        // Draw the lines
        for (int x = 0; x < linesP.rows(); x++) {
            double[] l = linesP.get(x, 0);
            Point x1 = new Point(l[0], l[1]);
            Point x2 = new Point(l[2], l[3]);
            //mgproc.line(cdstP, x1, x2, new Scalar(0, 0, 255), 3, Imgproc.LINE_AA, 0);
                Imgproc.line(cdstP, x1, x1, new Scalar(0, 0, 255), 3, Imgproc.LINE_AA, 0);
                Imgproc.line(cdstP, x2, x1, new Scalar(255, 0, 255), 3, Imgproc.LINE_AA, 0);
        }
        */
        // Show results
       // HighGui.imshow("Source", src);
        HighGui.imshow("Detected Lines (in red) - Standard Hough Line Transform",th);
        //HighGui.imshow("Detected Lines (in red) - Probabilistic Line Transform", cdstP);
        //  HighGui.imshow("LINES",lines);
        // Wait and Exit
        HighGui.waitKey();
        System.exit(0);
  //   HighGui.imshow("Erosion", destination);
    // HighGui.imshow("Dilatacion", destination2);

     //HighGui.waitKey();
    // System.exit(0);
    }
            static {
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
}
