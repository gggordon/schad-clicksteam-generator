# S.C.H.A.D Clickstream Generator

Author G. Gordon	

## Overview

This project is a part of a larger project SCHAD created by GGordon.

It's aim is to generate data providing clickstream insights into customer product views

It will provide the following (randomly) on each iteration

- Customer Id
- ScrollXPosition (X position in window)
- Product Viewed Id
- ScrollYPosition (Y position in window)
- Customer Zip Code
- Date Time

A sample line would look like 
```
11993|241.10043|20532|432.68088|534|2020/04/26 22:01:32
```

and the stream if viewed from an application eg. telnet
```
11460|163.62515|61410|1129.1833|1113|2020/04/26 22:02:06
4711|1924.4882|90815|1187.7152|485|2020/04/26 22:02:07
5588|1976.1198|70618|713.022|1042|2020/04/26 22:02:08
9449|420.69885|10873|553.48816|609|2020/04/26 22:02:08
1793|454.05835|98406|505.1231|146|2020/04/26 22:02:09
6022|117.14658|77389|1118.3727|562|2020/04/26 22:02:10
7399|1364.7094|81380|1151.32|875|2020/04/26 22:02:11
6748|821.0758|13179|732.9199|253|2020/04/26 22:02:12
```

## Acquiring a release

You may either build a release or use one of the pre-existing releases

### Pre-existing releases

Pre-existing releases are available in the `releases` folder and in another folder indicating their version. For eg. version `1.0.0` is available in `./releases/1.0.0`

### Building a release

This is an eclipse project managed by maven. 

1. You may either export the project from eclipse as a runnable jar
2. You may build a version using `mvn package`

## Running the application

You may either run the application directly or as a Docker Container.

### Running the application directly

```
java -jar schad-clickstream-generator-1.0.0.jar --port=5005 --interval=1000
```

Where 
  - `-clickstream-generator-1.0.0.jar` is the application name
  - `--port=5005`  [OPTIONAL - defaults to 3005] port streaming server should be available on
  - `--interval=1000`  [OPTIONAL - defaults to 800] streaming interval in milli seconds

You should see the port and interval output if you are monitoring the application via the console eg.
```
Running Emitter on Port 5005 every 1000 milli-seconds
```

### Running the application using docker

Dockerfiles are available for each release . Eg to run release 1.0.0
```
cd releases/1.0.0 # Change director to release folder
docker build -t schad-streaming-generator .
docker run --name my-schad-streaming-generator schad-streaming-generator
```
#### Build Arguments Available
- port=5005 - port
- interval=1000 - interval

#### Environment Arguments Available
- PORT=5005 - port
- INTERVAL=1000 - interval

Eg. Running with an interval of 500 milliseconds
```
docker run --name my-schad-streaming-generator -e INTERVAL=500 schad-streaming-generator
```

## LICENSE

[Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)


