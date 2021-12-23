package Reflection;

import java.util.*;
import java.lang.reflect.*;
public class ReflectionTest {
    public static void main(String[] args){
        String name;
        if(args.length>0){
            name=args[0];
        }
        else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter class name (eg.java.util.Date) : ");
            name = scanner.next();
            scanner.close();
        }

        try{
            //print class name and superclass name
            final Class<?> cl=Class.forName(name);
            final Class<?> supercl=cl.getSuperclass();
            System.out.print("class "+name);
            if(supercl != null && supercl != Object.class){
                System.out.print("extends "+supercl.getName());
            }
            System.out.print("\n{\n");
            printConstructors(cl);
            System.out.println();
            printMethods(cl);
            System.out.println();
            printFields(cl);
            System.out.println("}");
        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
        }
    }
    //Constructor, Method, Field 출력
    //Class 클래스에 존재하는 Constructor, Method, Field 클래스들
    public static void printConstructors(final Class<?> cl){
        // java.lang.reflect.Constructor
        final Constructor<?>[] constructors =cl.getDeclaredConstructors();
        for(final Constructor<?> constructor : constructors){
            System.out.print("  "+Modifier.toString(constructor.getModifiers()));
            System.out.print("  "+constructor.getName()+"(");


            //print parameter types
            final Class<?>[] parameterType=constructor.getParameterTypes();
            for(int j=0; j<parameterType.length;j++){
                if(j>0){
                    System.out.print(",");
                }
                System.out.print(parameterType[j].getName());
            }
            System.out.println(") { }");
        }
    }
    public static void printMethods(final Class<?> cl){
        final Method[] methods =cl.getDeclaredMethods();
        for(final Method method:methods){
            final Class<?> returnType=method.getReturnType();

            // print modifiers, return type and method name
            System.out.print(" " + Modifier.toString(method.getModifiers()));
            System.out.print(" " + returnType.getName() + " " + method.getName() + "(");
            // print parameter types
            final Class<?>[] parameterTypes = method.getParameterTypes();
            for(int j=0; j<parameterTypes.length; j++){
                if(j>0){
                    System.out.print(",");
                }
                System.out.print(parameterTypes[j].getName());
                System.out.println(") { }");
            }
        }
    }
    public static void printFields(final Class<?> cl){
        final Field[] fields = cl.getDeclaredFields();
        for (final Field field : fields) {
            final Class<?> type = field.getType();
            System.out.print(" " + Modifier.toString(field.getModifiers()));
            System.out.println(" " + type.getName() + " " + field.getName() + ";");
        }
    }

}
