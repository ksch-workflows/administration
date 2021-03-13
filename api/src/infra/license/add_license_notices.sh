#!/usr/bin/env bash

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
PROJECT_DIR=$SCRIPT_DIR/../../..

for i in $(find $PROJECT_DIR -name "*.java" -not -path "*/fileTemplates*")
do
    if ! grep -q Copyright $i ; then
        cat $SCRIPT_DIR/license-notice-java.txt $i >$i.new && mv $i.new $i
    fi
done
