#!/bin/bash

CURPATH=$(pwd)

echo "delete all pods and services in namespace instagnam-ns"
kubectl delete all --all -n instagnam-ns

echo "destroy namespace instagnam-ns"
kubectl delete namespace instagnam-ns
