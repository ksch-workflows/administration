#!/usr/bin/env bash

SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" >/dev/null 2>&1 && pwd )"
PROJECT_ROOT=${SCRIPT_DIR%/administration/api*}/administration

cd $PROJECT_ROOT || exit 1

rm -rf doc/api-reference
cp -r build/generated-snippets doc/api-reference
