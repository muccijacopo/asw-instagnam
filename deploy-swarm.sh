#!/bin/bash

echo "Starting swarm"
docker stack deploy --compose-file docker-compose-swarm.yml instagnam
echo "Swarm started"

