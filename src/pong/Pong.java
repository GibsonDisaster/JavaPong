package pong;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {

    private int width, height;
    public static Ball ball;
    public static Paddle paddle;
    public static Enemy enemy;
    
    public Pong(int width, int height) {
        this.width = width;
        this.height = height;
        this.addKeyListener(this);
        this.setFocusable(true);
        paddle = new Paddle(10, 100, 20, 20);
        enemy = new Enemy(10, 100, 610, 20);
        ball = new Ball(20, 20, this.height/2, this.width/2);

        
        JFrame frame = new JFrame("Pong");
        frame.setFocusable(false);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        
        this.setSize(width, height);
        this.addKeyListener(this);
        
        frame.add(this);
        frame.setVisible(true);
    }
    
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, this.width, this.height);
        g.setColor(Color.WHITE);
        g.fillRect(ball.getX(), ball.getY(), ball.getWidth(), ball.getHeight());
        g.fillRect(paddle.getX(), paddle.getY(), paddle.getWidth(), paddle.getHeight());
        g.fillRect(enemy.getX(), enemy.getY(), enemy.getWidth(), enemy.getHeight());
        g.drawString(Integer.toString(ball.getScore()), width/2 + 10, 20);
        g.drawString(Integer.toString(ball.getEScore()), width/2 + 50, 20);
        repaint();
        Toolkit.getDefaultToolkit().sync();
    }
    
    public static void main(String[] args) throws InterruptedException {
        new Pong(640, 480);

            while (true) {
                ball.move();
                Thread.sleep(10);
            }
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public Paddle getPaddle() {
        return paddle;
    }
    
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch(e.getKeyCode()) {
            case KeyEvent.VK_UP:
                paddle.move(1);
                break;
            case KeyEvent.VK_DOWN:
                paddle.move(-1);
                break;
            case KeyEvent.VK_W:
                enemy.move(1);
                break;
            case KeyEvent.VK_S:
                enemy.move(-1);
                break;
            case KeyEvent.VK_BACK_SPACE:
                ball.reset();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    
    }
}
