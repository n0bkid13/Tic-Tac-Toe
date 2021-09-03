import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe implements ActionListener {
    private Random random;
    private JFrame frame;
    private JPanel titlePanel;
    private JPanel buttonPanel;
    private JLabel textField;
    private JButton[] buttons;
    private boolean player1_turn;

    public TicTacToe(){
        random = new Random();
        frame = new JFrame();
        titlePanel = new JPanel();
        buttonPanel = new JPanel();
        textField = new JLabel();
        buttons = new JButton[9];

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 800);
        frame.getContentPane().setBackground(new Color(50, 50, 50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        textField.setBackground(new Color(25, 25, 25));
        textField.setForeground(new Color(25, 255, 0));
        textField.setFont(new Font("Ink Free", Font.BOLD, 75));
        textField.setHorizontalAlignment(JLabel.CENTER);
        textField.setText("Tic-Tac-Toe");
        textField.setOpaque(true);

        titlePanel.setLayout(new BorderLayout());
        titlePanel.setBounds(0, 0, 800, 100);

        buttonPanel.setLayout(new GridLayout(3, 3));
        buttonPanel.setBackground(new Color(150, 150, 150));

        for(int i = 0 ; i < this.buttons.length ; ++i){
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        titlePanel.add(textField);
        frame.add(titlePanel, BorderLayout.NORTH);
        frame.add(buttonPanel);

        firstTurn();
    }

    public void firstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e){
            System.out.println("");
        }

        if(random.nextInt(2) == 0){
            this.player1_turn = true;
            textField.setText("X turn");
        } else{
            this.player1_turn = false;
            textField.setText("O turn");
        }
    }

    public boolean checkButtons(int a, int b, int c, String character){
        if(this.buttons[a].getText().equals(character) && this.buttons[b].getText().equals(character) && this.buttons[c].getText().equals(character))
            return true;
        return false;
    }

    public void check(){
        // X wins
        if(checkButtons(0, 1, 2, "X"))
            xWins(0, 1, 2);
        if(checkButtons(3, 4, 5, "X"))
            xWins(3, 4, 5);
        if(checkButtons(6, 7, 8, "X"))
            xWins(6, 7, 8);
        if(checkButtons(0, 3, 6, "X"))
            xWins(0, 3, 6);
        if(checkButtons(1, 4, 7, "X"))
            xWins(1, 4, 7);
        if(checkButtons(2, 5, 8, "X"))
            xWins(2, 5, 8);
        if(checkButtons(0, 4, 8, "X"))
            xWins(0, 4, 8);
        if(checkButtons(2, 4, 6, "X"))
            xWins(2, 4, 6);

        // Y wins
        if(checkButtons(0, 1, 2, "O"))
            yWins(0, 1, 2);
        if(checkButtons(3, 4, 5, "O"))
            yWins(3, 4, 5);
        if(checkButtons(6, 7, 8, "O"))
            yWins(6, 7, 8);
        if(checkButtons(0, 3, 6, "O"))
            yWins(0, 3, 6);
        if(checkButtons(1, 4, 7, "O"))
            yWins(1, 4, 7);
        if(checkButtons(2, 5, 8, "O"))
            yWins(2, 5, 8);
        if(checkButtons(0, 4, 8, "O"))
            yWins(0, 4, 8);
        if(checkButtons(2, 4, 6, "O"))
            yWins(2, 4, 6);
    }

    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0 ; i < 9 ; ++i)
            buttons[i].setEnabled(false);

        textField.setText("X wins");
    }

    public void yWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i = 0 ; i < 9 ; ++i)
            buttons[i].setEnabled(false);

        textField.setText("O wins");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0 ; i < 9 ; ++i){
            if(e.getSource() == buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.RED);
                        buttons[i].setText("X");
                        this.player1_turn = false;
                        textField.setText("O turn");
                        check();
                    }
                } else{
                    if(buttons[i].getText().equals("")){
                        buttons[i].setForeground(Color.BLUE);
                        buttons[i].setText("O");
                        this.player1_turn = true;
                        textField.setText("X turn");
                        check();
                    }
                }
            }
        }
    }
}
