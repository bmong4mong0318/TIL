## JVM Memory Structure

JVM : Java Virtual Machine

Running a Java program means running the JVM and running the Java program on it.

OS - JVM - java program

JVM -> `intermediator` 

Due to these characteristics, even if an error occurs in a Java program, `only the JVM is down, and the entire system is not damaged.`

The Java language basically does not leave dynamic allocation to the programmer.

In C language, through functions such as malloc(), realloc(), etc., the programmer dynamically allocates the heap area, and the programmer directly releases the allocation through the free() function. 

However, in Java, `the task is entirely handled by the JVM` and performed by itself. This feature is called `garbage collection.`

<img src=/home/thomas/Desktop/TIL/img/>

- **Garbage Collector**
  
  During execution of the Java program, it determines whether all the dynamically created objects have been used, and the allocated memory is released.

- **Class Loader**

	This is a module that reads class information into the JVM. The class is dynamically loaded when the program is running.

- **Execution Engine**

	When class loading is completed, it is a module that reads Java bytecode and actually executes it.

- **Runtime Data Areas**
  
	This is the memory allocated by the operating system while the JVM is running when a Java program is executed. 
	
	It is largely divided into **5 categorie**s according to the use of memory.
  
  1. Method Area(Static Area)
  2. Heap Area
  3. Stack Area
  4. PC Register
  5. Native Method Stack Area
