# Getting Started

A simple rest server written in Java 11, Spring and Docker.<br>
It uses the https://github.com/guikeller/tides to do the heavy work.<br>
You will be able to get tide stations and tides for a given station on a given date. 

### Pre-requisites
Install the following tools / framework:

* Java 11
* Maven 3
* Docker


### Build 
Follow the steps below:

```bash
mvn clean package -DskipTests
docker build -t open-tides/open-tides:latest .
```

### Run
To run the server do the following
```bash
docker run --name open-tides -p 8080:8080 open-tides/open-tides:latest
```

### Docker Compose
To run it using docker-compose
```bash
cd docker-compose
docker-compose up -d
```

### Endpoints
```bash
curl http://localhost:8080/tideStations
curl http://localhost:8080/tideStationsTree
curl http://localhost:8080/highLowTides?tideStation=Bolama,%20Guinea-Bissau&tideDate=2021-06-03
curl http://localhost:8080/hourlyTides?tideStation=Bolama,%20Guinea-Bissau&tideDate=2021-06-03
```

### License

MIT - Enjoy!
