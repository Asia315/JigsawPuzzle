package zhou.ya.liu.ui;

import javax.swing.*;

//注册界面
public class RegistrationInterface extends JFrame {
    public RegistrationInterface(){
        //设置界面的宽高
        this.setSize(488,500);
        //设置界面的标题
        this.setTitle("注册界面");
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面在最上面
        this.setAlwaysOnTop(true);
        //设置关闭java虚拟机的要求
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //设置界面的显示,最后在最后
        this.setVisible(true);
    }
}
