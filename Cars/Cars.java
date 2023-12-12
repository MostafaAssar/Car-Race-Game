package Cars;
import com.sun.opengl.util.*;
import java.awt.*;
import javax.media.opengl.*;
import javax.swing.*;

public class Cars extends JFrame  {

    public static void main(String[] args) {
        new Cars();
    }


    public Cars() {
        GLCanvas glcanvas;
        Animator animator;

        CarsGLEventListener listener = new CarsGLEventListener();
        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(listener);
        glcanvas.addKeyListener(listener.easy);
        glcanvas.addKeyListener(listener.hard);
        glcanvas.addKeyListener(listener.multi);
        glcanvas.addKeyListener((listener.ai));
        glcanvas.addMouseListener(listener);
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        animator = new FPSAnimator(24);
        animator.add(glcanvas);
        animator.start();

        setTitle("Car Race");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setFocusable(true);
        glcanvas.requestFocus();
    }
}
