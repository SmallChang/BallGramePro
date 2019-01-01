package com.company;

import javax.swing.*;
import java.awt.*;

/**
 * 用来测试注释的用法，包含单行、多行、文档注释
 * 这是文档注释
 */
public class BallGame2 extends JFrame{
    //两个对象
    Image ball = Toolkit.getDefaultToolkit().getImage("img/ball.jpg");
    Image desk = Toolkit.getDefaultToolkit().getImage("img/desk.jpg");

    double x=100;//小球横坐标
    double y=100;//小球纵坐标
    double degree=3.14/3;//弧度，此处指60度

    //画小球和桌子的方法
    public void paint(Graphics g){
        System.out.println("123456");
        g.drawImage(desk,0,0,null);
        g.drawImage(ball,(int)x,(int)y,null);

        x=x+10*Math.cos(degree);
        y=y+10*Math.sin(degree);
        //这是单行注释，此处指碰到上下边框角度变换
        if(y>500-40-30||y<40+40){//40是标题栏的高度
            degree=-degree;
        }
        //碰到左右边框角度变换
        if(x<40||x>856-40-30){
            degree=Math.PI-degree;
        }
    }

    //画窗口
    void launchFrame(){
        setSize(856,500);
        setLocation(50,50);
        setVisible(true);
        //重画窗口，每秒画25次



/*        while(true){
            repaint();//它再去调用paint方法
            try{
                Thread.sleep(40);//每次画完暂停40ms,1秒=1000ms，大约1秒画25次
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        这是多行注释
        */

    }
    public static void main(String[] args/*多行注释的小技巧，我是行内注释*/) {
	    BallGame2 game = new BallGame2();
	    game.launchFrame();
    }

}
