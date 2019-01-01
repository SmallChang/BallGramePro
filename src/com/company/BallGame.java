package com.company;

import javax.swing.*;
import java.awt.*;

public class BallGame extends JFrame{
    //两个对象
    Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.jpg");
    Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.jpg");
    double x=100;//小球横坐标
    double y=100;//小球纵坐标
    boolean right = true;//方向
    //画小球和桌子的方法
    public void paint(Graphics g){
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);
        if(right){
            x=x+5;
        }else{
            x=x-5;
        }
        if(x>856-40-30){   //30是小球的直径
            right=false;
        }
        if(x<40){       //40是桌球边框的宽度
            right=true;
        }
    }
    //画窗口
    void launchFrame(){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);
        //重画窗口，每秒画25次
        while(true){
            repaint();//它再去调用paint方法
            try{
                Thread.sleep(40);//每次画完暂停40ms,1秒=1000ms，大约1秒画25次
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
	    BallGame game = new BallGame();
	    game.launchFrame();
    }

}
