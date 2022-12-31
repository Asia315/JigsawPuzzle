package zhou.ya.liu.ui;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


//登录界面
public class LoginPage extends JFrame implements MouseListener {
    JTextField userNameText=null;
    JPasswordField passwordText=null;
    JTextField verificationCodeText=null;
    JButton login=null;
    JButton registered=null;

    public LoginPage(){
        //页面设置
        initFrame();
        //背景
        page();
        //设置界面的显示,最后在最后
        this.setVisible(true);

    }
    //页面

    private void page() {
        //用户名
        JLabel userName=new JLabel(new ImageIcon("image\\login\\用户名.png"));
        userName.setBounds(116, 135, 47, 17);
        this.getContentPane().add(userName);
        //用户名输入框
        userNameText=new JTextField();
        userNameText.setBounds(195, 134, 200, 30);
        this.getContentPane().add(userNameText);

        //密码
        JLabel password=new JLabel(new ImageIcon("image\\login\\密码.png"));
        password.setBounds(130, 195, 32, 16);
        this.getContentPane().add(password);
        //密码输入框
        passwordText=new JPasswordField();
        passwordText.setBounds(196,195,200,30);
        this.getContentPane().add(passwordText);

        //验证码
        JLabel verificationCode=new JLabel(new ImageIcon("image\\login\\验证码.png"));
        verificationCode.setBounds(133, 256, 50, 30);
        this.getContentPane().add(verificationCode);
        //验证码输入框
        verificationCodeText=new JTextField();
        verificationCodeText.setBounds(195, 256, 100, 30);
        this.getContentPane().add(verificationCodeText);

        //登录
        login=new JButton(new ImageIcon("image\\login\\登录按钮.png"));
        login.setBounds(123, 310, 128, 47);
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        //绑定事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //注册
        registered=new JButton(new ImageIcon("image\\login\\注册按钮.png"));
        registered.setBounds(256, 310, 128, 47);
        //绑定事件
        registered.addMouseListener(this);
        //去除按钮的边框
        registered.setBorderPainted(false);
        //去除按钮的背景
        registered.setContentAreaFilled(false);
        this.getContentPane().add(registered);

        //背景
        JLabel backGround=new JLabel(new ImageIcon("image\\register\\background.png"));
        backGround.setBounds(40,40,470,390);
        this.getContentPane().add(backGround);
        //刷新
        this.getContentPane().repaint();
    }

    //设置界面
    private void initFrame() {
        //设置界面的宽高
        this.setSize(488,430);
        //设置界面的标题
        this.setTitle("拼图游戏1.0V登录界面");
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面在最上面
        this.setAlwaysOnTop(true);
        //设置关闭java虚拟机的要求
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }
    //按住不松
    @Override
    public void mousePressed(MouseEvent e) {
        if(e.getSource()==login){
            login.setIcon(new ImageIcon("image\\login\\登录按下.png"));
        }else if(e.getSource()==registered){
            registered.setIcon(new ImageIcon("image\\login\\注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
