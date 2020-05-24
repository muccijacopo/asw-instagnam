#!/bin/bash

# Script per avviare l'applicazione Instagnam 

echo Running INSTAGNAM

gradle build && docker-compose up

#java -Xms64m -Xmx128m -jar ricette/build/libs/ricette.jar &
#java -Xms64m -Xmx128m -jar connessioni/build/libs/connessioni.jar &
#java -Xms64m -Xmx128m -jar ricette-seguite/build/libs/ricette-seguite.jar &
#
#java -Xms64m -Xmx128m -jar api-gateway/build/libs/api-gateway.jar &
