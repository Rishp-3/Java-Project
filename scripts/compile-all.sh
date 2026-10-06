#!/usr/bin/env bash
# Compiles every standalone example under the numbered module folders (01-... to 27-...).
# Each file is compiled on its own because the examples all live in the default package
# and several reuse class names (Main, Reader, Writer, ...), so they can't share one build.
set -u
cd "$(dirname "$0")/.."
out="$(mktemp -d)"
trap 'rm -rf "$out"' EXIT
ok=0; fail=0
while IFS= read -r -d '' f; do
  if javac --release 17 -d "$out" "$f" 2>"$out/err.txt"; then
    ok=$((ok + 1))
  else
    fail=$((fail + 1)); echo "FAILED: $f"; head -5 "$out/err.txt"
  fi
done < <(find [0-9][0-9]-* -name '*.java' -print0 | sort -z)
echo "compiled ok=$ok failed=$fail"
[ "$fail" -eq 0 ]
