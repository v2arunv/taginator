# taginator

Two things that I've wanted to try out for a while now - [Vert.x] (http://vertx.io/) and [Apache Cassandra] (http://cassandra.apache.org/), so I thought I'd try to make a very simple REST service to perform CRUD operations on Cassandra using Vertx's Web Server. 

## What for?
Text data along with some tags, which will be generated by the server automatically and then stored.

## How?
Vertx has something called an **event bus** (implementation of Hazelcast) which basically allows messaging between different applications running on the same Vertx framework. Therefore, the event bus can be used to pub/sub to messages on various applications running on the JVM and even JavaScript running inside a browser. The idea of the project is to create a Java App that can trigger procedure calls in a browser window when new information such as tags are available. 

## How to deploy?
Will be including a Dockerfile soon to allow deployment anywhere
