#!/bin/bash

CURPATH=$(pwd)

echo "removing old containers"
docker-compose -f docker-compose.yml down --remove-orphans

echo "cleaning springboot apps"
gradle clean
if [ $? != 0 ] ; then
	exit
fi

echo "compiling springboot apps"
gradle build
if [ $? != 0 ] ; then
	exit
fi

echo "running new containers"
docker-compose -f docker-compose.yml up --build
if [ $? != 0 ] ; then
	exit
fi
