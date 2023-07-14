# advent-of-code-2018

Solutions for Advent of Code 2018 in Clojure

## Installation

Download from http://github.com/Yi-Jiahe/advent-of-code-2018.

## Usage

Run `lein repl` to start the repl, then `(run day)` where day is an integer between 1-25 to get the results based on the input in resources/day_i_input.txt.

Run `lein test` to test the solutions.

Run `scripts/new_day.sh day` with an integer between 1-25 to generate the boilerplate from the templates.

## Days

### Day 1: Chronal Calibration

Given a list of frequency changes (+/-) find the resultant frequency after applying all the changes (part 1), and the first repeated frequency looping through the list (part 2).

### Day 2: Inventory Management System

Given a list of box-IDs, find the checksum based on the product of the number of box-IDs with exactly 2 and 3 repeated characters (part 1), and the pair of correct IDs which are one character apart.

### Day 3: No Matter How You Slice It

Given a list of rectangular claims to a sheet of fabric, find the total area of the overlapping claims (part 1), and find the only claim which does not overlap any other (part 2).

### Day 4: Repose Record

Given a schedule of when guards fall asleep, identify the guard who slept the most and which minute they slept the most for (part 1), then identify the minute each guard slept the most for and how many times they were asleep that minute. The answer for part two is the number of the guard who slept the most for a particular minute times the minute.

## License

Copyright © 2022 FIXME

This program and the accompanying materials are made available under the
terms of the Eclipse Public License 2.0 which is available at
http://www.eclipse.org/legal/epl-2.0.

This Source Code may also be made available under the following Secondary
Licenses when the conditions for such availability set forth in the Eclipse
Public License, v. 2.0 are satisfied: GNU General Public License as published by
the Free Software Foundation, either version 2 of the License, or (at your
option) any later version, with the GNU Classpath Exception which is available
at https://www.gnu.org/software/classpath/license.html.
