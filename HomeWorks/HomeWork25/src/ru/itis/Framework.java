package ru.itis;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Framework {
    // used to check whether a class is a primitive wrapper
    // and to retrieve the underlying primitive type
    private static HashMap<Class, Class> wrapperToPrimitive = new HashMap<>();

    static {
        wrapperToPrimitive.put(Byte.class, byte.class);
        wrapperToPrimitive.put(Short.class, short.class);
        wrapperToPrimitive.put(Integer.class, int.class);
        wrapperToPrimitive.put(Long.class, long.class);
        wrapperToPrimitive.put(Float.class, float.class);
        wrapperToPrimitive.put(Double.class, double.class);
        wrapperToPrimitive.put(Character.class, char.class);
        wrapperToPrimitive.put(Boolean.class, boolean.class);
    }

    private Framework() {}

    public static <T> List<T> getObjects(int count, Class<T> aClass, Object... args) {
        Constructor<?> constructor = findConstructor(aClass, args);

        List<T> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            try {
                result.add((T)constructor.newInstance(args));
            } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
                throw new IllegalStateException(e);
            }
        }
        return result;
    }

    private static <T> Constructor<?> findConstructor(Class<T> aClass, Object[] args) {
        Constructor<?>[] constructors = aClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (checkConstructor(constructor, args)) {
                return constructor;
            }
        }
        throw new IllegalArgumentException("No constructor found for specified arguments");
    }

    private static boolean checkConstructor(Constructor<?> constructor, Object[] args) {
        if (constructor.getParameterCount() != args.length) {
            return false;
        }
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i = 0; i < args.length; i++) {
            if (!checkMatch(parameterTypes[i], args[i])) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkMatch(Class<?> parameterType, Object argument) {
        //a primitive type cannot be null, and any other type matches null
        if (argument == null) {
            return !parameterType.isPrimitive();
        }

        //if the types match, return true
        Class<?> argumentType = argument.getClass();
        if (argumentType.equals(parameterType)) {
            return true;
        }

        // otherwise, check whether argumentType is a primitive wrapper class
        // and if that's the case, check if underlying primitive class matches parameterType
        return wrapperToPrimitive.containsKey(argumentType)
                && wrapperToPrimitive.get(argumentType).equals(parameterType);
    }


}
