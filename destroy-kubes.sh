#!/bin/bash

CURPATH=$(pwd)

echo "delete all pods and services in namespace instagnam-ns"
kubectl -n instagnam-ns delete pod,svc --all

echo "destroy resources"
kubectl delete namespace instagnam-ns
