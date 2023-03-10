package packVista;

import packModelo.ModeloMenu;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class VistaMenu extends JFrame implements Observer {
    private JTextArea titulo;
    private JLabel labelJugadores;
    private JTextField textNumJugadores;
    private JLabel labelBots;
    private JTextField  textNumBots;
    private JLabel labelPokemons;
    private JTextField  textNumPokemons;
    private JButton botonInicio;
    public VistaMenu()
    {
        //Construccion de la interfaz grafica del menu
        setTitle("Pokemon Battle");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titulo = new JTextArea("POKEMON BATTLE ARENA");

        //Panel para la interaccion del usuario
        JPanel panelInput = new JPanel(new GridLayout(4,2, 10, 10));

        panelInput.add(getLabelJugadores());
        panelInput.add(getTextNumJugadores());

        panelInput.add(getLabelBots());
        panelInput.add(getTextNumBots());

        panelInput.add(getLabelPokemons());
        panelInput.add(getTextNumPokemons());

        panelInput.add(getBotonInicio());

        //Agregamos el panel y distribuimos el FRAME
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panelInput, BorderLayout.WEST);
        getContentPane().add(titulo, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof ModeloMenu){
            if(arg instanceof  boolean[]){
                boolean[] inputs = (boolean[]) arg;
                JLabel labels [] = new JLabel[]{labelJugadores, labelBots, labelPokemons};

                for(int ite = 0 ; ite < inputs.length ; ite++){
                    if(inputs[ite]){//Si el input esta bien
                        labels[ite].setForeground(Color.BLACK);
                        switch (ite){
                            case 0:
                                labels[ite].setText("N?? Jugadores: ");
                                break;
                            case 1:
                                labels[ite].setText("N?? Bots: ");
                                break;
                            case 2:
                                labels[ite].setText("N?? Pokemons: ");
                                break;
                        }
                    }
                    else{
                        labels[ite].setText("Error");
                        labels[ite].setForeground(Color.RED);
                    }
                }
            }
            else{
                //CERRAR LA VENTANA MENU
                dispose();
            }
        }
    }

    //SETTERS
    //1
    /**
     * JLabel para el campo de jugadores
     * */
    public JLabel getLabelJugadores(){
        if(labelJugadores == null){
            this.labelJugadores = new JLabel("N?? Jugadores: ");
            //MODIFICACIONES PARA LA INTERFAZ GRAFICA
        }
        return labelJugadores;
    }

    /**
     * JTextField para el campo jugadores
     * */
    public JTextField getTextNumJugadores(){
        if(textNumJugadores == null){
            this.textNumJugadores = new JTextField();
            //MODIFICACIONES PARA LA INTERFAZ GRAFICA
        }
        return textNumJugadores;
    }

    //2
    /**
     * JLabel para el campo de bots
     * */
    public JLabel getLabelBots(){
        if(labelBots == null){
            this.labelBots = new JLabel("N?? Bots: ");
            //MODIFICACIONES PARA LA INTERFAZ GRAFICA
        }
        return labelBots;
    }

    /**
     * JTextField para el campo bots
     * */
    public JTextField getTextNumBots(){
        if(textNumBots == null){
            this.textNumBots = new JTextField();
            //MODIFICACIONES PARA LA INTERFAZ GRAFICA
        }
        return textNumBots;
    }

    //3
    /**
     * JLabel para el campo de jugadores
     * */
    public JLabel getLabelPokemons(){
        if(labelPokemons == null){
            this.labelPokemons = new JLabel("N?? Pokemons: ");
            //MODIFICACIONES PARA LA INTERFAZ GRAFICA
        }
        return labelPokemons;
    }

    /**
     * JTextField para el campo jugadores
     * */
    public JTextField getTextNumPokemons(){
        if(textNumPokemons == null){
            this.textNumPokemons = new JTextField();
            //MODIFICACIONES PARA LA INTERFAZ GRAFICA
        }
        return textNumPokemons;
    }

    /**
     * BOTON PARA INICIAR LA BATALLA
     * */
    public JButton getBotonInicio(){
        if(botonInicio == null){
            this.botonInicio = new JButton("Iniciar Batalla!");
            //MODIFICACIONES PARA LA INTERFAZ GRAFICA
        }
        return botonInicio;
    }
}
