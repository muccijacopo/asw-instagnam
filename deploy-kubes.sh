#!/bin/bash

CURPATH=$(pwd)

echo "create namespace"
kubectl create namespace instagnam-ns

echo "create resources"
kubectl apply -f instagnam-deployment.yaml -n instagnam-ns
