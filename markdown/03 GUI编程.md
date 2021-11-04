# 1. 简介

GUI的核心技术：[SWing AWT](https://zh.wikipedia.org/wiki/AWT) 

界面不美观，需要 jre 环境，但需要了解MVC架构，了解<font color='red'>监听</font>

![image-20210209230537694](https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210209230537694.png)

# 2 AWT组件

* 窗口
* 弹窗 <font color='red'>Frame</font>
* 面板 <font color='red'>Panel</font>
* 文本框
* 列表框
* 按钮
* 图片
* 监听事件
* 鼠标
* 键盘事件

## 2.1 弹窗 Frame

```java
package com.yifang.gui;

import java.awt.*;

public class TestFrame {

    public static void main(String[] args) {

        Frame frame = new Frame("我的第一个Java图形界面窗口");

        // 设置可见性
        frame.setVisible(true);

        // 设置窗口大小
        frame.setSize(400, 400);

        // 设置背景颜色
        frame.setBackground(new Color(201, 26, 26));

        // 弹出的初始位置
        frame.setLocation(200, 200);

        // 设置大小固定
        frame.setResizable(false);
    }
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210212162250169.png" alt="image-20210212162250169" style="zoom:67%;" />

窗口关不掉，结束Java程序即可

* 封装Frame

```java
package com.yifang.gui;

import java.awt.*;

public class MultiFrame {
    public static void main(String[] args) {
        // 展示多个窗口
        MyFrame myFrame1 = new MyFrame(100, 100, 200, 200, Color.red);
        MyFrame myFrame2 = new MyFrame(300, 100, 200, 200, Color.yellow);
        MyFrame myFrame3 = new MyFrame(100, 300, 200, 200, Color.blue);
        MyFrame myFrame4 = new MyFrame(300, 300, 200, 200, Color.black);

    }
}

class MyFrame extends Frame {
    static int id = 0;

    public MyFrame(int x, int y, int w, int h, Color color){
        super("MyFrame" + (++id));
        setVisible(true);               // 可见
        setBounds(x, y, w, h);          // 起始位置，长宽
        setBackground(color);           // 背景颜色
    }
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210212171409897.png" alt="image-20210212171409897" style="zoom:67%;" />

## 2.2 面板

* 面板不能单独存在，只能放在Frame里面

解决了关闭事件！

```java
package com.yifang.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        // 设置布局
        frame.setLayout(null);
        frame.setBounds(300, 300, 500,500);
        frame.setBackground(new Color(243, 219, 183));

        Panel panel = new Panel();   // 可以new多个panel，add到frame上
        // 设置panel坐标，相对于frame
        panel.setBounds(50, 50, 400, 400);
        panel.setBackground(new Color(252, 157, 157));

        frame.add(panel);
        frame.setVisible(true);

        // 监听事件，监听窗口关闭事件    System.exit(0);
        // 适配器模式
        frame.addWindowListener(new WindowAdapter() {
            // 窗口点击关闭时需要做的事情
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210213092237951.png" alt="image-20210213092237951" style="zoom:67%;" />

## 2.3 布局管理器

### 2.3.1 流式布局 FlowLayout

```java
package com.yifang.gui;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestFlowLayout {
    public static void main(String[] args) {

        Frame frame = new Frame();

        // 按钮
        Button button1 = new Button("button1");
        Button button2 = new Button("button2");
        Button button3 = new Button("button3");

        // 流式布局
        frame.setLayout(new FlowLayout(FlowLayout.CENTER));
        frame.setSize(400, 400);

        frame.add(button1);
        frame.add(button2);
        frame.add(button3);

        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            // 窗口点击关闭时需要做的事情
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210213093205489.png" alt="image-20210213093205489" style="zoom:67%;" />

### 2.3.2 东西南北中 BorderLayout

```java
public class TestBorderLayout {
    public static void main(String[] args) {
        Frame frame = new Frame();

        Button east = new Button("East");
        Button west = new Button("West");
        Button north = new Button("North");
        Button south = new Button("South");
        Button center = new Button("Center");

        frame.add(east, BorderLayout.EAST);
        frame.add(west, BorderLayout.WEST);
        frame.add(north, BorderLayout.NORTH);
        frame.add(south, BorderLayout.SOUTH);
        frame.add(center, BorderLayout.CENTER);

        frame.setBounds(100, 100, 500, 500);
        frame.setVisible(true);
    }
}
```

### 2.3.3 表格布局 GridLayout

```java
public static void main(String[] args) {
    Frame frame = new Frame();

    Button button1 = new Button("button1");
    Button button2 = new Button("button2");
    Button button3 = new Button("button3");
    Button button4 = new Button("button4");
    Button button5 = new Button("button5");
    Button button6 = new Button("button6");

    frame.setLayout(new GridLayout(3, 2));

    frame.add(button1);
    frame.add(button2);
    frame.add(button3);
    frame.add(button4);
    frame.add(button5);
    frame.add(button6);

    frame.pack();       // 自动优化布局，Java函数
    frame.setVisible(true);
}
```

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210213101813813.png" alt="image-20210213101813813" style="zoom:67%;" />

* 一个小练习：写出下面的界面

<img src="https://gitee.com/njuxyf/PictureBed/raw/master/CS-Notes/image-20210213135232357.png" alt="image-20210213135232357" style="zoom:67%;" />

* 分析：整个frame采用表格布局，frame上下用东西南北中BorderLayout布局，中间采用GridLayout布局

```java
public static void main(String[] args) {
    Frame frame = new Frame();
    frame.setVisible(true);
    frame.setLayout(new GridLayout(2, 1));
    frame.setBounds(50, 50, 400, 400);
    frame.setBackground(new Color(252, 157, 157));

    // 4个面板
    Panel panel1 = new Panel(new BorderLayout());
    Panel panel2 = new Panel(new GridLayout(2,1));
    Panel panel3 = new Panel(new BorderLayout());
    Panel panel4 = new Panel(new GridLayout(2,2));

    // 上面
    panel1.add(new Button("Wast-1"), BorderLayout.WEST);
    panel1.add(new Button("East-1"), BorderLayout.EAST);
    panel1.add(panel2, BorderLayout.CENTER);

    // 下面
    panel3.add(new Button("Wast-3"), BorderLayout.WEST);
    panel3.add(new Button("East-3"), BorderLayout.EAST);
    panel3.add(panel4, BorderLayout.CENTER);

    panel2.add(new Button("North-2"));
    panel2.add(new Button("South-2"));

    for (int i = 0; i < 4; i++) {
        panel4.add(new Button("button-" + i));
    }

    frame.add(panel1);
    frame.add(panel3);
}
```

总结：

1. Frame 是一个单独的窗口
2. Panel 无法单独显示，必须添加到某个容器中
3. 布局管理器
   1. FlowLayout
   2. BorderLayout
   3. GridLayout

4. 大小，位置，背景颜色，可见性，监听

## 2.4 事件监听

