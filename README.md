Scala NAO
=========

This is an early stage integration of Scala to the NAO Qi API. There are a couple of key elements:

* Notes: contains some org notes, and some saved scala repl commands to aid repl working with the robot
* The jnaoqi library: It is added here because the download has some issues that I had to resolve and here was the only place to put the code. As a result there are 2 build projects within the repo, the qibuild files and SBT. At the moment I only have MAC support, so if you are on a mac you don't need to build the JNI lib. If you are on anything else, please follow the build instructions on the aldebaran site.
* Various Scala files: These are in the places you expect to find them, some basic implicts that are required, and then some library functions to illustrate some of the "pimp my library" capability of scala and akka integration. There is a single proxy factory, just for convienience sake

How To
------

* Add the naoqi dynamic libs to your path, e.g: export DYLD_LIBRARY_PATH=/xxx/yy/naoqi-sdk-1.14.5-mac64/lib/
* Place the libjnaoqi.jnilib(in lib folder) in the java extensions folder, e.g: /Library/Java/Extentions/
* Adjust the IP in ProxyFactory
* sbt compile
* sbt console

You can then use some example commands from Scratch.scala, you must start with ":load notes/Init.scala" and ":load notes/InitProxies.scala"    

Trouble Shooting
---------------

* Generally you have a path issue, check you have all the paths correct. Especially if you get any complaints relating to dynamic libs
* If you get any error messages relating to type conversion/Variant, then you can't got the implicits in scope or I am missing a required conversion, pull requests welcome.

Todo
----

* Extract the IP address out to config or something. 




