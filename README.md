# CleanCode-Architecture-Demo
A sample app that showcases our Clean architecture approach to build Android applications. 
Android Clean - Cost Tracker

A sample app that showcases my Clean architecture approach to build Android applications. It is a simple app with core features that include:
* Displaying a list of towns
* Clicking on a summarized cost should display details of town detail
That's it. For now.
You are free to download it, modify it, fork it and do anything you want with it.

# What steps to follow to create clean code?

# Overview
![image](https://imgur.com/3ocpoqW.png)

# Domain Layer
![image](https://imgur.com/ldAnBCu.png)

# Data Layer
![image](https://imgur.com/lhsb34v.png)

# Entity Mapping Relationship
![image](https://imgur.com/UD39JZn.png)

# Presentation Layer
![image](https://imgur.com/XNpdX1p.png)

# End Result (Complate Flow)
![image](https://imgur.com/sbqXlrB.png)

# Packing
![image](https://imgur.com/T5Ocr7T.png)

# What is Clean Architecture?
In Clean, code is separated into layers in an onion shape. The outer layers of the onion depend on the inner layers but the opposite is not true. It can have an arbitrary amount of layers but for most applications there are 3 layers:
* Outer: Implementation layer
* Middle: Presenter/Controller layer
* Inner: Business logic layer
The implementation layer is where everything framework specific happens. Framework specific code includes every line of code that is not solving your problem, this includes all Android stuff like creating activities and fragments, sending intents, and more general code like networking code and databases. The purpose of the presenter/controller layer is to act as a connector between your business logic and framework specific code.
The most important layer is the business logic layer. This is where you actually solve the problem you want to solve building your app. This layer does not contain any framework specific code and you should be able to run it without an emulator. This way you can have your business logic code that is easy to test, develop and maintain. That is the main benefit of Clean Architecture.
More general info about Clean Architecture can be found on this blog. This is a general explanation so let me explain how should it look like specifically in Android and how exactly do I build apps using Clean.
How this app is structured
I've found that the most practical way to build Android apps with Clean is with the following approach. This is how this sample app is structured:
Outer layers
* The presentation layer has a standard MVP structure. All Activites and Fragments, everything view related and user-facing is put into the layer.
* Database specific code is inside the domain layer.
* Network specific code is inside the data layer.
* Any other framework specific code would be put into its own layer, for example in Android a bluetooth layer is something I often have.
Inner/Core layer
* Business logic is put into the domain layer.
Although I am omitting a middle layer, that is not actually true. Because my presentation layer actually includes Presenters, this provides a good separation of code between presentation and domain layers. Communication between layers is done using interfaces as explained in the blog linked above. In short, the inner layer only uses an interface while its the job of the outer layer to implement it. This way the inner layer only cares about calling methods on an interface, without actually knowing what is going on under the hood.
You can read more about it in my detailed guide.

