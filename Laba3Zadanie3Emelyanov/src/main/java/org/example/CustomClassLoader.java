package org.example;

import java.io.*;

public class CustomClassLoader extends ClassLoader {
    private String classPath;

    public CustomClassLoader(String classPath) {
        this.classPath = classPath;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            String filePath = classPath + File.separator + name.replace('.', '/') + ".class";
            FileInputStream fis = new FileInputStream(filePath);
            byte[] classData = new byte[fis.available()];
            fis.read(classData);
            fis.close();
            return defineClass(name, classData, 0, classData.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Could not load class: " + name, e);
        }
    }
}
