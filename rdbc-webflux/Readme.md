#Application build with mvn
`mvn clean compile package`

#docker image build
`docker build -f Dockerfile -t rdbc-webflux .`

#run the application in docker
`docker run -p 6080:6080 rdbc-webflux`