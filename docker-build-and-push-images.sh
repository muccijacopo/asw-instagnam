#!/bin/bash

CURPATH=$(pwd)

echo "building springboot apps"
gradle clean build
if [ $? != 0 ] ; then
	exit
fi

echo "building containers"
docker-compose -f docker-compose-images.yml build
#docker-compose -f docker-compose-swarm-images.yml build

echo "pushing containers"
docker-compose -f docker-compose-images.yml push
#docker-compose -f docker-compose-swarm-images.yml push
