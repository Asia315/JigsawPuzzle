package test;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class eventButton {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        //设置界面的宽高
        jFrame.setSize(603,680);
        //设置界面的标题
        jFrame.setTitle("拼图游戏1.0");
        //设置界面居中
        jFrame.setLocationRelativeTo(null);
        //设置界面在最上面
        jFrame.setAlwaysOnTop(true);
        //设置关闭java虚拟机的要求
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消界面居中
        jFrame.setLayout(null);
        //创建按钮
        JButton jbt=new JButton("点我");
        jbt.setBounds(0,0,100,50);
        jbt.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("成功");
            }
        }
        );
        jFrame.getContentPane().add(jbt);
        jFrame.setVisible(true);
    }
}
