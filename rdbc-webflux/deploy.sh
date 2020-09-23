mvn clean compile package
docker build -f Dockerfile -t rdbc-webflux .
docker run -p 6080:6080 rdbc-webflux