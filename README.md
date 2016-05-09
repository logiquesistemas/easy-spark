# EasySpark

EasySpark is a simple and lightweight Java web framework built for rapid development. EasySpart uses Spark Framework and add some facilities to organize your code in a MVC architecture.

##Quick Start

Fist of all create a simple java class with @Controller annotation.

```java
package br.com.logique;

import br.com.logique.easyspark.annotations.Controller;

@Controller
public class SimpleController {

    public String hello(){
        return "Hello World";
    }
    
}

```

In your main class start a EasySpark calling the setUp method. It is necessary to inform base package where the engine will look for controllers.

```java
import br.com.logique.easyspark.SparkEngine;

public class App {

    public static void main(String[] args) {
        SparkEngine engine = new SparkEngine.Builder()
                .withBasePackage("br.com.logique")
                .build();
        engine.setUp();
    }

}
```


##Getting Start
Comming soon...
