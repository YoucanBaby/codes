/**
 * @BelongsProject: codes
 * @BelongsPackage: PACKAGE_NAME
 * @Author: xuyifang
 * @CreateTime: 2021-09-19 14:28
 * @Description:
 */
class EqualExample {

    private int x;
    private int y;

    public EqualExample(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 		// 是否为同一个对象的引用
            return true;
        if (obj == null || getClass() != obj.getClass()) 	// 是否是同一个类型
            return false;

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
