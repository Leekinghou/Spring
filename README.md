# Spring
Spring notebook

# 前置知识·反射
## 学习要点
- 反射及其作用
- 反射的四个核心类
- 反射在项目中的作用

## 什么是反射
**反射（reflection.reflect）是代码`在运行时`动态访问类与对象的技术**
- 来自于`java.lang.reflection.reflect`  
  初学java时，要实例化一个对象，需要：
```java
//Object obj = new Object<>();

MathOperation mathOperation = null;
// 因为newInstance()返回的是一个object对象，因此可以强转为MathOperation对象
mathOperation = (MathOperation) Class.forName("reflection.reflect." + op).newInstance();
int result = mathOperation.operate(a, b);
```
这个步骤在程序编译时运行。

## 反射的作用
大多数java框架都基于反射实现参数配置、动态注入等特性

## 反射核心类
|  方法   | 用途  |
|  ----  | ----  |
| Class.forName()  | 静态方法，用于获取指定Class对象 | 
| ClassObj.newInstance()  | 通过默认构造方法创建新的对象 |
| ClassObj.getConstructor()  | 获得指定的public修饰构造方法Constructor对象 |
| ClassObj.getMethod()  | 获得指定的public修饰Method对象 |
| ClassObj.getField()  | 获得指定的public修饰成员变量Field对象 |
