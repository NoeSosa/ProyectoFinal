import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.GLProfile;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;

import javax.swing.JFrame;

import com.jogamp.opengl.util.FPSAnimator;

public class Piramide10 implements GLEventListener {

   private GLU glu = new GLU();
   private float rtri = 0.0f;
      
   @Override
   public void display(GLAutoDrawable drawable) {
      final GL2 gl = drawable.getGL().getGL2();

      // Clear The Screen And The Depth Buffer
      gl.glClear( GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT );
      gl.glLoadIdentity(); // Reset The View
      gl.glTranslatef( -0.5f, 0.0f, -6.0f ); // Move the triangle
      gl.glRotatef( rtri, 0.0f, 1.0f, 0.0f );
      gl.glBegin( GL2.GL_TRIANGLES ); 
        
      //Dibujando las dimenciones de la piramide
      // De frente
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Rojo
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Arriba
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Verde
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Izquierda
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Azul
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); //Derecha
        
      // Derercha
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Rojo
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Arriba
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Blue
      gl.glVertex3f( 1.0f, -1.0f, 1.0f ); // Izquierda
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Verde
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Derecha
        
      // Left
      gl.glColor3f( 1.0f, 0.0f, 0.0f ); // Rojo
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Arriba
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Verde
      gl.glVertex3f( 1.0f, -1.0f, -1.0f ); // Izquierda
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Azul
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Derecha 
        
      //Izuierda
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Rojo
      gl.glVertex3f( 1.0f, 2.0f, 0.0f ); // Arriba
		
      gl.glColor3f( 0.0f, 0.0f, 1.0f ); // Azul
      gl.glVertex3f( -1.0f, -1.0f, -1.0f ); // Izquierda
		
      gl.glColor3f( 0.0f, 1.0f, 0.0f ); // Verde
      gl.glVertex3f( -1.0f, -1.0f, 1.0f ); // Derech
		
      gl.glEnd(); // Termianar de dibujar
      gl.glFlush();
      rtri += 0.2f;
   }
   
   public void dispose( GLAutoDrawable drawable ) {
      //method body
   }
   
   @Override
   public void init( GLAutoDrawable drawable ) {
      //method body
   }
   
   @Override
   public void reshape( GLAutoDrawable drawable, int x, int y, int width, int height ) {
	
     
      final GL2 gl = drawable.getGL().getGL2();
      if(height lt;=;)
         height = 1;
			
      final float h = ( float ) width / ( float ) height;
      gl.glViewport( 0, 0, width, height );
      gl.glMatrixMode( GL2.GL_PROJECTION );
      gl.glLoadIdentity();
		
      glu.gluPerspective( 45.0f, h, 1.0, 20.0 );
      gl.glMatrixMode( GL2.GL_MODELVIEW );
      gl.glLoadIdentity();
   }
   
   public static void main( String[] args ) {
   
      
      final GLProfile profile = GLProfile.get( GLProfile.GL2 );
      GLCapabilities capabilities = new GLCapabilities( profile );
         
      // Canvas
      final GLCanvas glcanvas = new GLCanvas( capabilities );
      Triangle3d triangle = new Triangle3d();
		
      glcanvas.addGLEventListener( triangle );
      glcanvas.setSize( 400, 400 );
		
      final JFrame frame = new JFrame ( "3d Triangle (shallow)" );
		
      frame.getContentPane().add( glcanvas );
      frame.setSize( frame.getContentPane().getPreferredSize() );
      frame.setVisible( true );
		
      final FPSAnimator animator = new FPSAnimator(glcanvas,300,true);
      animator.start();
   }
	
}