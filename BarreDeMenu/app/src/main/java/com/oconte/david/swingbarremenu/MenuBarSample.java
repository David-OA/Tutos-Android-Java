package com.oconte.david.swingbarremenu;

public class MenuBarSample {

    /* Construction de l'interface graphique
    public MenuBarSample() {
        super( "JMenuBar sample" );
        this.setSize(600,400);
        this.setLocationRelativeTo( null );
        this.setDefaultCloseOperation( DISPOSE_ON_CLOSE );

        // Construction et injection de la barre de menu
        this.setJMenuBar( this.createMenuBar() );
    }*/


    /* Methode de construction de la barre de menu
    private JMenuBar createMenuBar() {

        // La barre de menu à proprement parler
        JMenuBar menuBar = new JMenuBar();

        // Définition du menu déroulant "File" et de son contenu
        JMenu mnuFile = new JMenu( "File" );
        mnuFile.setMnemonic( 'F' );

        JMenuItem mnuNewFile = new JMenuItem( "New File" );
        mnuNewFile.setIcon( new ImageIcon( "icons/new.png" ) );
        mnuNewFile.setMnemonic( 'N' );
        mnuNewFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK) );
        mnuNewFile.addActionListener( this::mnuNewListener );
        mnuFile.add(mnuNewFile);

        mnuFile.addSeparator();

        JMenuItem mnuOpenFile = new JMenuItem( "Open File ..." );
        mnuOpenFile.setIcon( new ImageIcon( "icons/open.png" ) );
        mnuOpenFile.setMnemonic( 'O' );
        mnuOpenFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK) );
        mnuFile.add(mnuOpenFile);

        JMenuItem mnuSaveFile = new JMenuItem( "Save File ..." );
        mnuSaveFile.setIcon( new ImageIcon( "icons/save.png" ) );
        mnuSaveFile.setMnemonic( 'S' );
        mnuSaveFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK) );
        mnuFile.add(mnuSaveFile);

        JMenuItem mnuSaveFileAs = new JMenuItem( "Save File As ..." );
        mnuSaveFileAs.setIcon( new ImageIcon( "icons/save_as.png" ) );
        mnuSaveFileAs.setMnemonic( 'A' );
        mnuFile.add(mnuSaveFileAs);

        mnuFile.addSeparator();

        JMenuItem mnuExit = new JMenuItem( "Exit" );
        mnuExit.setIcon( new ImageIcon( "icons/exit.png" ) );
        mnuExit.setMnemonic( 'x' );
        mnuExit.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_F4, KeyEvent.ALT_DOWN_MASK) );
        mnuFile.add(mnuExit);

        menuBar.add(mnuFile);

        // Définition du menu déroulant "Edit" et de son contenu
        JMenu mnuEdit = new JMenu( "Edit" );
        mnuEdit.setMnemonic( 'E' );

        JMenuItem mnuUndo = new JMenuItem( "Undo" );
        mnuUndo.setIcon( new ImageIcon( "icons/undo.png" ) );
        mnuUndo.setMnemonic( 'U' );
        mnuUndo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuUndo);

        JMenuItem mnuRedo = new JMenuItem( "Redo" );
        mnuRedo.setIcon( new ImageIcon( "icons/redo.png" ) );
        mnuRedo.setMnemonic( 'R' );
        mnuRedo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuRedo);

        mnuEdit.addSeparator();

        JMenuItem mnuCopy = new JMenuItem( "Copy" );
        mnuCopy.setIcon( new ImageIcon( "icons/copy.png" ) );
        mnuCopy.setMnemonic( 'C' );
        mnuCopy.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuCopy);

        JMenuItem mnuCut = new JMenuItem( "Cut" );
        mnuCut.setIcon( new ImageIcon( "icons/cut.png" ) );
        mnuCut.setMnemonic( 't' );
        mnuCut.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_X, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuCut);

        JMenuItem mnuPaste = new JMenuItem( "Paste" );
        mnuPaste.setIcon( new ImageIcon( "icons/paste.png" ) );
        mnuPaste.setMnemonic( 'P' );
        mnuPaste.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK) );
        mnuEdit.add(mnuPaste);

        menuBar.add(mnuEdit);

        // Définition du menu déroulant "Help" et de son contenu
        JMenu mnuHelp = new JMenu( "Help" );
        mnuHelp.setMnemonic( 'H' );

        menuBar.add( mnuHelp );

        return menuBar;
    }

    public void mnuNewListener( ActionEvent event ) {
        JOptionPane.showMessageDialog( this, "Button clicked !" );
    }

    public static void main(String[] args) throws Exception {
        UIManager.setLookAndFeel( new NimbusLookAndFeel() );
        MenuBarSample frame = new MenuBarSample();
        frame.setVisible(true);
    }*/
}
