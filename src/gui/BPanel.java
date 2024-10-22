package gui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 * La clase BPanel implementa las características del panel de la aplicación.
 * Hereda de JPanel.
 *
 * @author Thanasis
 * @author tasosxak
 * @version 1.0
 * @since 5/1/17
 *
 */
public class BPanel extends JPanel {

    private ImageIcon background;

    public BPanel() {
        this(true, "", 0, 0,1080, 1000); // Tamaño predeterminado del panel
    }

    public BPanel(String imageName) {
        this(true, imageName, 0, 0, 1080, 1920); // Panel con imagen de fondo
    }

    public BPanel(boolean visible) {
        this(visible, "", 0, 0, 1080, 1920); // Panel visible o no
    }

    public BPanel(boolean visible, String imageName) { // Imagen fondo menú
        this(visible, imageName, 0, 0, 1080, 1920); // Panel visible o no con imagen de fondo
    }

    public BPanel(String imageName, int x, int y, int width, int height) {
        this(true, imageName, x, y, width, height); // Panel con dimensiones, posición e imagen de fondo
    }

    public BPanel(int x, int y, int width, int height) {
        this(true, "", x, y, width, height); // Panel con dimensiones y posición
    }

    public BPanel(boolean visible, String imageName, int x, int y, int width, int height) {
        setOpaque(false);
        setBounds(x, y, width, height);
        setLayout(null);
        //setLayout(new FlowLayout(FlowLayout.CENTER));

        setVisible(visible);

        if (!imageName.equals("")) {
            background = new ImageIcon(getClass().getResource("/images/" + imageName)); // Cargar archivo de imagen
        }

        /*
        try {
                background = ImageIO.read(new File("src/images/" + imageName));
            } catch (IOException ex) {
                Logger.getLogger(BPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
         */
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        if (background != null) {
            g.drawImage(background.getImage(), 0, 0, getWidth(), getHeight(), null); // Dibujar la imagen en el panel
        }
    }

    /**
     * El método setImage permite agregar una imagen de fondo al panel
     *
     * @param imageName El nombre del archivo de imagen junto con su tipo
     */
    public void setImage(String imageName) {

        background = new ImageIcon(getClass().getResource("/images/" + imageName));

        /*
        try {
            background = ImageIO.read(new File("src/images/" + imageName));
        } catch (IOException ex) {
            Logger.getLogger(BPanel.class.getName()).log(Level.SEVERE, null, ex);
        }
        repaint();
         */
    }

    /**
     * El método setFocusOnClick nos permite enfocar el panel cuando se hace clic
     * en él, y no en otros componentes que inicialmente podrían tener el foco.
     *
     */
    public void setFocusOnClick() {

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                requestFocus();
            }
        });

    }

}
