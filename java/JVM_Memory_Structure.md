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

		It is a runtime constant pool of `classes` and `interfaces` read by the JVM.

		`Static variables`, `constructors`, `methods`, and `member variables` that are components of a class are stored in this space.

  2. Heap Area

		This is the space where the dynamically created object (object or instance created by the `new` operator) while the Java program is executed is stored. 
		
		Objects created here can be referenced by fields of other objects or by other methods existing on the stack.
		
		If the referenced variable disappears, this object is considered unnecessary and deallocated by the Garbage Collector.

  3. Stack Area

		When a `method` is called, it is allocated in this area. The first to come in is the last to go out (FILO).
		
		When a thread is created, each thread is allocated one stack for each thread. `Local variables` generated when a method is executed are also stored in the stack.
		
		In the stack, objects in the heap area can be referenced, and primitive type variables are created directly on the stack (objects are in the heap area).
  4. PC Register

		Contains the address of the currently executing JVM instruction. It can be said that the role of the CPU is similar to that of the PC.

  5. Native Method Stack Area

		A stack for code in languages other than Java. It exists to execute code of other languages called through JNI (Java Native Interface).




https://hyoje420.tistory.com/2