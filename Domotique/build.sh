#!/bin/bash

javac -Xlint -cp . *.java
jar -cfm Demo.jar manifest.mf * 
java -cp Demo.jar WindowLampe1 | java -cp Demo.jar WindowLampe2_3 | java -cp Demo.jar InterrupteurClient

