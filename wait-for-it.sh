#!/usr/bin/env bash
# wait-for-it.sh

host="$1"
shift
port="$1"
shift

until nc -z "$host" "$port"; do
  echo "Esperando a $host:$port..."
  sleep 2
done

exec "$@"
