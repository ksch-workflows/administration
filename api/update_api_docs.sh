#!/usr/bin/env bash

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"

cd $SCRIPT_DIR || exit 1

rm -rf doc/api-reference

cp -r build/generated-snippets doc/api-reference

