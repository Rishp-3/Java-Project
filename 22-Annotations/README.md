# Annotations in Java

## 📌 Topic
Annotation code ke baare me extra information (metadata) deta hai. Ye `@` se start hota hai aur compiler ya runtime tools use padhte hain.

## 🎯 What You Will Learn

- Built-in annotations (`@Override`, `@Deprecated`, `@SuppressWarnings`, `@FunctionalInterface`)
- Custom annotation banana
- `@Retention` aur `@Target`
- Annotation ko reflection se padhna

## 💻 Code

```java
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Info {
    String author() default "Unknown";
    int version() default 1;
}

class Service {
    @Info(author = "Rishabh", version = 2)
    public void run() {
        System.out.println("Service running");
    }

    @Deprecated
    public void oldMethod() {
        System.out.println("Old method");
    }

    @Override
    public String toString() {
        return "Service";
    }
}

public class Annotations {
    public static void main(String[] args) throws Exception {
        Method m = Service.class.getMethod("run");

        if (m.isAnnotationPresent(Info.class)) {
            Info info = m.getAnnotation(Info.class);
            System.out.println("Author: " + info.author());
            System.out.println("Version: " + info.version());
        }

        new Service().run();
    }
}
```

## 🧠 Explanation

### `@interface Info`
Naya custom annotation banane ka syntax.

### `@Retention(RUNTIME)`
Annotation program chalte waqt bhi available rahe (reflection se padhne ke liye zaroori).

### `@Target(METHOD)`
Ye annotation sirf methods par lag sakta hai.

### `default`
Annotation element ki default value.

## ▶️ Output

```text
Author: Rishabh
Version: 2
Service running
```

## 🔑 Important Points

- `@Override` galti pakadta hai: parent me method na ho to compile error.
- Frameworks (Spring, JUnit, Hibernate) annotations par hi chalte hain: `@Test`, `@Autowired`, `@Entity`.
- Retention types: `SOURCE`, `CLASS`, `RUNTIME`.
- Annotation khud kuch nahi karta, koi tool/code use padhta hai.

## 📝 Practice

1. `@Override` hata ke compile error dekho.
2. `@Deprecated` method call karke warning dekho.
3. Apna `@Test` jaisa annotation banao.
4. Class par lagne wala annotation banao (`ElementType.TYPE`).

## 🚀 Challenge

`@RunMe` custom annotation banao aur reflection se sirf us annotation wale methods ko chalao.
