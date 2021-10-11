package example;

/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 14:28
 * @Description:
 */
public class EqualExample {

    protected class test {

    }

    private int x;
    private int y;

    public EqualExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        // 两个对象的地址是否相同
        if (this == obj)
            return true;
        // 两个对象是否是同一个类
        if (obj == null || getClass() != obj.getClass())
            return false;
        // 两个对象内部的值是否相同
        EqualExample e = (EqualExample) obj;
        return e.x == x && e.y == y;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        EqualExample test1 = new EqualExample(x, y);
        EqualExample test2 = new EqualExample(1, 2);
        System.out.println(test1.equals(test2));		// true;
    }
}
