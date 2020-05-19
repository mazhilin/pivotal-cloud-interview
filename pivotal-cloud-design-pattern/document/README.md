### 设计模式专题
#### 设计模式
#### 单例模式
* [1].基于枚举类型实现EnumSingleton单例模式

* [2].基于饿汉式实现HungrySingleton单例模式

* [3].基于静态内部类实现InnerSingleton单例模式
```Java
public class InnerSingleton implements Singleton {
    /**
     * [1].定义一个静态内部类
     */
    private static class InnerSingletonHolder {
        private static InnerSingleton instance = new InnerSingleton();
    }

    /**
     * [2].封装一个私有构造函数
     */
    private InnerSingleton() {
    }

    /**
     * [3].封装静态实例方法进行赋值操作
     *
     * @return InnerSingleton实例对象
     */
    public static InnerSingleton getInstance() {
        return InnerSingletonHolder.instance;
    }

}
```
* [4].基于懒汉式实现LazySingleton单例模式
```Java
public class LazySingleton implements Singleton {
    /**
     * [1].定义一个静态变量
     */
    private static LazySingleton instance;

    /**
     * [2].封装一个私有构造函数
     */
    private LazySingleton() {
    }

    /**
     * [3].封装静态实例方法进行赋值操作
     *
     * @return LazySingleton实例对象
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            instance = new LazySingleton();
        }
        return instance;
    }
}
```
* [5].基于双重检查锁定实现LockSingleton单例模式
```Java
public class LockSingleton implements Singleton {
    /**
     * [1].定义一个静态变量
     */
    private static LockSingleton instance;

    /**
     * [2].封装一个私有构造函数
     */
    private LockSingleton() {
    }

    /**
     * [3].封装静态实例方法进行赋值操作
     *
     * @return LockSingleton实例对象
     */
    public static LockSingleton getInstance() {
        if (instance == null) {
            synchronized (LockSingleton.class) {
                if (instance == null) {
                    instance = new LockSingleton();
                }
            }
        }
        return instance;
    }
}
```
#### 工厂模式
