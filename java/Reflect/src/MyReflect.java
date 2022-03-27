import java.lang.reflect.Method;

/**
 * Created by nickyang on 2017/6/4.
 */
public class MyReflect {
    public static void main(String[] args)
    {
        System.out.println("Hello World!\n");

        Class<?> mt = null;
        try{
            mt = Class.forName("MyTest");
        }catch(Exception e) {
            e.printStackTrace();
        }

        System.out.println("ClassName: " + mt.getName());

        try {
            System.out.println("Tyring to get object by reflect");
            MyTest obj = (MyTest)mt.newInstance();
            obj.doTest();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        try{
            System.out.println("Trying to execute method by reflect");
            Method method = mt.getMethod("doTest");
            method.invoke(mt.newInstance());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
