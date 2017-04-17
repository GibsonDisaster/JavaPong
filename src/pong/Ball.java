package pong;

import static pong.Pong.enemy;
import static pong.Pong.paddle;

public class Ball {
    
    private int width, height, x, y, xSpeed, ySpeed, score, escore;
    
    public Ball(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.xSpeed = 2;
        this.ySpeed = 3;
        score = 0;
        escore = 0;
    }
    
    public void reset() {
        score = 0;
        escore = 0;
        this.x = 320;
        this.y = 220;
    }
    
    public int getScore() {
        return score;
    }
    
    public int getEScore() {
        return escore;
    }
    
    public int getX() {
        return this.x;
    }
    
    public int getY() {
        return this.y;
    }
    
    public int getWidth() {
        return this.width;
    }
    
    public int getHeight() {
        return this.height;
    }
    
    public void move() {
        if (this.x >= 640-this.width) {
            score += 1;
            this.x = 320;
            this.y = 220;
        } else if (this.x < 0) {
            escore += 1;
            this.x = 320;
            this.y = 220;
        }
        else if (this.y >= 480-(2 * this.width))
            ySpeed = -3;
        else if (this.y < 0)
            ySpeed = 3;
        
        if (this.x == paddle.getX()+paddle.getWidth() && this.y > paddle.getY() && this.y+this.height < paddle.getY() + paddle.getHeight()) {
            xSpeed = 2;
        }
        
        if (this.x+this.width > enemy.getX() && this.y > enemy.getY() && this.y+this.height < enemy.getY()+enemy.getHeight()) {
            xSpeed = -2;
        }

        this.x += xSpeed;
        this.y += ySpeed;
    }
    
}
