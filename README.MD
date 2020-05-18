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

A sample line would look like (using `text` output format)
```
11993|241.10043|20532|432.68088|534|2020/04/26 22:01:32
```

and the stream if viewed from an application eg. `telnet localhost [PORT]`
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

A sample line would look like (using `json` output format)
```
{"customerId":7869,"browser_y_position":1097.1743,"zipCode":28804,"browser_x_position":774.58954,"productId":1274,"date_time":"2020/05/18 15:31:05"}
```
and the stream if viewed from an application eg. `telnet localhost [PORT]`
```
{"customerId":7869,"browser_y_position":1097.1743,"zipCode":28804,"browser_x_position":774.58954,"productId":1274,"date_time":"2020/05/18 15:31:05"}
{"customerId":6216,"browser_y_position":1111.0393,"zipCode":83398,"browser_x_position":783.7781,"productId":974,"date_time":"2020/05/18 15:31:06"}
{"customerId":604,"browser_y_position":1982.5916,"zipCode":20470,"browser_x_position":708.27356,"productId":161,"date_time":"2020/05/18 15:31:07"}
{"customerId":1939,"browser_y_position":1785.1422,"zipCode":81092,"browser_x_position":1068.0463,"productId":1062,"date_time":"2020/05/18 15:31:08"}
{"customerId":6703,"browser_y_position":1961.3462,"zipCode":84635,"browser_x_position":153.77553,"productId":591,"date_time":"2020/05/18 15:31:09"}
{"customerId":9843,"browser_y_position":1665.709,"zipCode":97239,"browser_x_position":309.40805,"productId":801,"date_time":"2020/05/18 15:31:09"}
```

## Acquiring a release

You may either build a release or use one of the pre-existing releases

### Pre-existing releases

Pre-existing releases are available in the `releases` folder and in another folder indicating their version. For eg. version `2.0.0` is available in `./releases/2.0.0`

### Building a release

This is an eclipse project managed by maven. 

1. You may either export the project from eclipse as a runnable jar
2. You may build a version using `mvn package`

## Running the application

You may either run the application directly or as a Docker Container.

### Running the application directly

```
java -jar schad-clickstream-generator-2.0.0.jar --port=5005 --interval=1000  --output-format=json
```

Where 
  - `-clickstream-generator-1.0.0.jar` is the application name
  - `--port=5005`  [OPTIONAL - defaults to 3005] port streaming server should be available on
  - `--interval=1000`  [OPTIONAL - defaults to 800] streaming interval in milli seconds
  - `--output-format=json`  [OPTIONAL - defaults to 'json'] output format as [text|json]

You should see the port and interval output if you are monitoring the application via the console eg.
```
Running Emitter on Port 5005 every 1000 milli-seconds using format json
```

### Running the application using docker

Dockerfiles are available for each release . Eg to run release 2.0.0
```
cd releases/2.0.0 # Change director to release folder
docker build -t schad-streaming-generator .
docker run --name my-schad-streaming-generator schad-streaming-generator
```
#### Build Arguments Available
- port=5005 - port
- interval=1000 - interval
- output_format=json - output format

#### Environment Arguments Available
- PORT=5005 - port
- INTERVAL=1000 - interval
- OUTPUT_FORMAT=json - output format

Eg. Running with an interval of 500 milliseconds
```
docker run --name my-schad-streaming-generator -e INTERVAL=500 schad-streaming-generator
```

## Change Log

#### 2.0.0 - JSON Emitter Available
- Json emitter available 
#### 1.1.0 - First Docker Release
- First Docker Release
#### 1.0.0 - Initial Release
- Text Stream Emitter

## LICENSE

[Apache License 2.0](https://www.apache.org/licenses/LICENSE-2.0)


