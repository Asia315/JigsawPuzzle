package zhou.ya.liu.ui;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

//游戏界面
public class GameInterface extends JFrame implements KeyListener , ActionListener {
    int [][] twoArr =new int[4][4];
    /**记录空白方块的位置2
     *
     */
    int x=0;
    int y=0;
    String path="image\\animal\\animal1\\";
    /**定义一个数组,存储正确的数据*/
    int [][] win={
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0},
    };
    int sum=0;
    JMenuBar jMenuBar=new JMenuBar();
    /**创建菜单的两个选项--1.功能  2.关于我们*/
    /**功能*/
    JMenu functionMenu=new JMenu("功能");
    /**关于我们*/
    JMenu understandMenu=new JMenu("关于我们");
    /**更换图片*/
    JMenu ChangePicture=new JMenu("更换图片");

    //创建选项下面的条目
    /**功能的*/
    JMenuItem replayingItem=new JMenuItem("重新游戏");
    JMenuItem loginItem=new JMenuItem("重新登录");
    JMenuItem closItem=new JMenuItem("关闭游戏");
    /**关于我们的*/
    JMenuItem accountItem=new JMenuItem("微信");
    /**更换图片的功能*/
    JMenuItem girl=new JMenuItem("美女");
    JMenuItem animals=new JMenuItem("动物");
    JMenuItem sport=new JMenuItem("运动");
    public GameInterface() {
        //初始化界面
        initFrame();
        //初始化菜单
        initMenu();
        //打乱图片
        initData();
        //初始化图片
        initImage();
        //设置界面的显示,最好在最后
        this.setVisible(true);
    }
    //打乱图片
    private void initData() {
        int [] arr={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        Random r=new Random();
        for (int i = 0; i < arr.length; i++) {
            int index =r.nextInt(arr.length);
            int temp=arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] ==0){
                x=i/4;
                y=i%4;
            }
            twoArr[i/4][i % 4]=arr[i];
        }
    }
    //放置图片
    private void initImage() {
        //清除所有图片
        this.getContentPane().removeAll();
        if(victory()){
            JLabel win=new JLabel(new ImageIcon("image\\win.png"));
            win.setBounds(203,283,197,73);
            this.getContentPane().add(win);
        }
        JLabel win =new JLabel("步数"+sum);
        win.setBounds(50,30,100,20);
        this.getContentPane().add(win);
        for (int i = 0; i < 4; i++) {
            for (int j = 0;  j< 4; j++) {
                int temp=twoArr[i][j] ;
                //创建一个放图片的容器
                JLabel jLabel=new JLabel(new ImageIcon(path+temp+".jpg"));
                jLabel.setBounds(105*j+83,105*i+134,105,105);
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //管理容器放入界面
                this.add(jLabel);
            }
        }
        JLabel backGround=new JLabel(new ImageIcon("image\\background.png"));
        backGround.setBounds(40,40,508,560);
        this.getContentPane().add(backGround);
        //刷新
        this.getContentPane().repaint();
    }
    //创建菜单
    private void initMenu() {
        //把功能选项添加进去
        functionMenu.add(replayingItem);
        functionMenu.add(loginItem);
        functionMenu.add(closItem);

        //把关于我们选项添加进去
        understandMenu.add(accountItem);

        //添加更换图片的功能
        ChangePicture.add(girl);
        ChangePicture.add(animals);
        ChangePicture.add(sport);


        //给功能选项添加事件
        replayingItem.addActionListener(this);
        loginItem.addActionListener(this);
        closItem.addActionListener(this);
        //给关于我们选项添加事件
        accountItem.addActionListener(this);
        //给更换图片选项添加事件
        girl.addActionListener(this);
        animals.addActionListener(this);
        sport.addActionListener(this);


        //添加菜单的两个功能
        jMenuBar.add(functionMenu);
        jMenuBar.add(understandMenu);
        jMenuBar.add(ChangePicture);

        //给界面设置菜单
        this.setJMenuBar(jMenuBar);
    }
    //设置界面
    private void initFrame() {
        //设置界面的宽高
        this.setSize(603,680);
        //设置界面的标题
        this.setTitle("拼图游戏1.0");
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面在最上面
        this.setAlwaysOnTop(true);
        //设置关闭java虚拟机的要求
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //取消界面居中
        this.setLayout(null);
        //给界面添加监控
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
    //按住不松触发
    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if (code == 96){
            //清除所有图片
            this.getContentPane().removeAll();
            //放图片
            JLabel jLabel=new JLabel(new ImageIcon(path+"\\all.jpg"));
            jLabel.setBounds(83,134,420,420);
            this.getContentPane().add(jLabel);
            //放背景
            JLabel backGround=new JLabel(new ImageIcon("image\\background.png"));
            backGround.setBounds(40,40,508,560);
            this.getContentPane().add(backGround);
            //刷新
            this.getContentPane().repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e)   {
        //如果游戏胜利,游戏结束
        if(victory()){
            return;
        }
        int code=e.getKeyCode();
        if (code==37){
            System.out.println("向左移动");
            if(y==3){
                return;
            }
            twoArr[x][y]=twoArr[x][y+1];
            twoArr[x][y+1]=0;
            y++;
            sum++;
            initImage();
        }else if(code==38){
            System.out.println("向上移动");
            if(x==3){
                return;
            }
            twoArr[x][y]=twoArr[x+1][y];
            twoArr[x+1][y]=0;
            x++;
            sum++;
            initImage();
        }else if(code==39){
            System.out.println("向右移动");
            if(y==0){
                return;
            }
            twoArr[x][y]=twoArr[x][y-1];
            twoArr[x][y-1]=0;
            y--;
            sum++;
            initImage();
        }else if(code==40){
            if(x==0){
                return;
            }
            System.out.println("向下移动");
            twoArr[x][y]=twoArr[x-1][y];
            twoArr[x-1][y]=0;
            x--;
            sum++;
            initImage();
        }else if(code==96){
            initImage();
        }else if(code==87){
            twoArr=new int[][]{
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,0},
            };
            initImage();
            //刷新
            this.getContentPane().repaint();
        }
    }

    //判断数组和win的数组是否相同
    public boolean victory(){
        for (int i = 0; i < twoArr.length; i++) {
            for (int j = 0; j < twoArr.length; j++) {
                if(twoArr[i][j]!=win[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Random r=new Random();
        Object obj=e.getSource();
        if(obj==replayingItem){
            System.out.println("重新开始");
            sum=0;
            initData();
            initImage();
        }else if(obj==loginItem){
            System.out.println("重新登陆");
            this.setVisible(false);
            new LoginPage();
        }else if(obj==closItem){
            System.out.println("关闭游戏");
            System.exit(0);
        }else if(obj==accountItem){
            System.out.println("微信");
            JDialog j=new JDialog();
            JLabel jLabel=new JLabel(new ImageIcon("image\\cd8ac6dbe733a02fa06732200021449.jpg"));
            jLabel.setBounds(0,0,1118,1524);
            j.getContentPane().add(jLabel);
            j.setSize(1200,1200);
            //在最上面
            j.setAlwaysOnTop(true);
            //居中
            j.setLocationRelativeTo(null);
            //不关闭无法操作
            j.setModal(true);
            //显示
            j.setVisible(true);
        }else if(obj==girl){
            System.out.println("美女");
            int number=r.nextInt(1,12);
            path="image\\girl\\girl"+number+"\\";
            sum=0;
            initData();
            initImage();
        }else if(obj==animals){
            System.out.println("动物");
            int number=r.nextInt(1,9);
            path="image\\animal\\animal"+number+"\\";
            sum=0;
            initData();
            initImage();
        }else if(obj==sport){
            System.out.println("运动");
            int number=r.nextInt(1,11);
            path="image\\sport\\sport"+number+"\\";
            sum=0;
            initData();
            initImage();
        }
    }




}
