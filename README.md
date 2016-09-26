# EasySpark

EasySpark is a simple and lightweight Java web framework built for rapid development. EasySpart uses Spark Framework (http://sparkjava.com/) and add some facilities to organize your code in a MVC architecture.

##Quick Start

First of all create a simple java class with @Controller annotation.

```java
package br.com.logique;

import Controller;

@Controller
public class SimpleController {

    public String hello(){
        return "Hello World";
    }
    
}

```
In your main class start a EasySpark calling the setUp method. It is necessary to inform the base package where the engine will look for controllers.

```java
import SparkEngine;

public class App {

    public static void main(String[] args) {
        SparkEngine engine = new SparkEngine.Builder()
                .withBasePackage("br.com.logique")
                .build();
        engine.setUp();
    }

}
```

Now you can access the web page below and see the results

```java
http://localhost:4567/simple/hello
```

For default, EasySpark create a different URL to each method following the pattern:

```java
http://host:port/controller/method
```

## Changing default route

If necessary you can change default route with @Path annotation.

```java
@Controller
public class SimpleController {

    @Path("/hello")
    public String hello(){
        return "Hello World";
    }
    
}

```
Now the hello method will be invoked when you access http://localhost:4567/hello 

## Receiving parameters

EasySpark automatically fill user parameter, so it is possible do this:

```java
@Controller
public class SimpleController {
    
    public String hello(String helloMsg){
        response.body("Hello");
        return helloMsg;
    }
    
}
```

To test, access http://localhost:4567/simple/hello?helloMsg=Hello!

Also it is possible to use @Path to create friendly URLs, like this:

```java
@Controller
public class SimpleController {
    
    @Path("hello/:helloMsg")
    public String hello(String helloMsg){
        response.body("Hello");
        return helloMsg;
    }
    
}
```

To test, access http://localhost:4567/hello/Hello!

EasySpark also automatically inject Spark Request and Response instances. Access http://sparkjava.com/documentation.html to more infomations about Request and Response functions. So you can do that:

```java
@Controller
public class SimpleController {

    @Path("/hello")
    public String hello(Request request, Response response){
        String param = request.queryParams("FOO");
        response.body("Hello");
        return "Hello World";
    }
    
}
```

## RESTful service

To do RESTful web service with EasySpark you just need to put @Get, @Post, @Delete or @Put annotations above methods, like this:

```java
@Controller
public class SimpleController {

    @Get
    @Path("hello/")
    public String helloGet() {
        return "Hello World";;
    }

    @Post
    @Path("hello/")
    public String helloPost() {
        return "Hello World";;
    }

    @Put
    @Path("hello/")
    public String helloPut() {
        return "Hello World";;
    }

    @Delete
    @Path("hello/")
    public String helloDelete() {
        return "Hello World";;
    }

}

```

All the paths are the same. So, the Http verb will solve the route conflict.
