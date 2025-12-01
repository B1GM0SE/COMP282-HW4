#!/usr/bin/env bash
#
# Data Structures Assignment Runner (Unix / macOS)
#
# Usage examples:
#   ./run.sh list    # compile and run CSLinkedListDriver
#   ./run.sh stack   # compile and run ListStackDriver
#   ./run.sh queue   # compile and run ArrayQueueDriver
#   ./run.sh all     # compile and run all three drivers
#
# Assumes:
#   - All .java files are in the same directory as this script
#   - No package statements in the .java files

set -e

if [ -z "$1" ]; then
  echo "Usage: $0 {list|stack|queue|all}"
  exit 1
fi

echo "Compiling Java files..."
javac *.java

case "$1" in
  list)
    echo
    echo "=== Running CSLinkedListDriver (linked list demos) ==="
    java CSLinkedListDriver
    ;;
  stack)
    echo
    echo "=== Running ListStackDriver (stack demos) ==="
    java ListStackDriver
    ;;
  queue)
    echo
    echo "=== Running ArrayQueueDriver (queue demos) ==="
    java ArrayQueueDriver
    ;;
  all)
    echo
    echo "=== Running CSLinkedListDriver (linked list demos) ==="
    java CSLinkedListDriver
    echo
    echo "=== Running ListStackDriver (stack demos) ==="
    java ListStackDriver
    echo
    echo "=== Running ArrayQueueDriver (queue demos) ==="
    java ArrayQueueDriver
    ;;
  *)
    echo "Unknown option: $1"
    echo "Usage: $0 {list|stack|queue|all}"
    exit 1
    ;;
esac
