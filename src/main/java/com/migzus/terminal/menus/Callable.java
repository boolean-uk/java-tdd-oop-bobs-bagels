package com.migzus.terminal.menus;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class Callable {
    private Method method;
    private final Object obj;

    private Object[] args = new Object[]{};

    public Callable(Object obj, String methodName) {
        try {
            for (Method method : obj.getClass().getMethods()) {
                if (method.getName().equals(methodName)) {
                    this.method = method;
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("There are no methods with the name " + methodName + " in the " + obj.getClass().getName() + " class!");
        }

        this.obj = obj;
    }

    public Callable(Object obj, String methodName, Object...args) {
        try {
            for (Method method : obj.getClass().getMethods()) {
                if (method.getName().equals(methodName)) {
                    this.method = method;
                    this.args = Arrays.stream(args).toArray();
                }
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("There are no methods with the name " + methodName + " in the " + obj.getClass().getName() + " class!");
        }

        this.obj = obj;
    }

    public Object call(Object...args) {
        if (method == null) {
            System.out.println("Invalid call. Method was not found therefore you cannot invoke the method.");
            return null;
        }

        try {
            if (this.args.length == 0 && args.length == 0)
                return method.invoke(obj);
            if (this.args.length > 0 && args.length > 0)
                return method.invoke(obj, this.args, args);
            else if (this.args.length > 0)
                return method.invoke(obj, this.args);
            else
                return method.invoke(obj, args);
        }
        catch (Exception e) {
            System.out.println(e + " " + e.getMessage());
            System.out.println("Cannot invoke call on callback! Target is: " + obj + ":" + method +
                    "\nExpected -> " + method.getName() + "(" + Arrays.toString(this.args) + ", " + Arrays.toString(args) + ")");
        }

        return null;
    }

    public Object getTargetReference() { return obj; }
}
