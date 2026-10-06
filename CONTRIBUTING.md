# Contributing

Thanks for helping improve this Java learning repo! Small fixes and new practice problems are both welcome.

## Quick start

```bash
git clone https://github.com/Rishp-3/Java-Project.git
cd Java-Project
mvn verify                 # all JUnit tests (needs JDK 17+ and Maven)
bash scripts/compile-all.sh   # compile every standalone example
```

## How the repo is organised

- `NN-Topic-Name/` folders hold small standalone examples (default package, run with `javac` + `java`).
- `src/main/java/practice/<module>/` holds practice problems; each has a JUnit 5 test in `src/test/java/practice/<module>/`.
- `PRACTICE.md` is the index of all practice problems.

## Adding a practice problem

1. Add the method to the matching class in `src/main/java/practice/<module>/` (or create a new class).
2. Document the idea and the time/space complexity in a short Javadoc comment.
3. Add tests for normal cases **and** edge cases (empty input, negatives, duplicates).
4. Run `mvn verify`.
5. Add the problem to `PRACTICE.md`.

## Pull requests

- One topic per pull request, with a clear title.
- CI must be green (tests on Java 17 and 21, plus the example compile check).
- Keep code readable: meaningful names, no unused code, comments that explain *why*.

## Reporting problems

Open an issue and pick the bug or suggestion template.
