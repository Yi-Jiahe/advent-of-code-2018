#! /bin/bash

if [[ -z $1 ]]; then
  echo "Please provide a day"
  exit 1
fi

day=$1

if [ -f "src/advent_of_code_2018/day_${day}.clj" ]; then
  echo "solution already exists for day ${day}"
  exit 1
fi

cp resources/day_n.txt "src/advent_of_code_2018/day_${day}.clj"
sed -i "s/DAY/${day}/g" "src/advent_of_code_2018/day_${day}.clj"
cp resources/day_n_test.txt "test/advent_of_code_2018/day_${day}_test.clj"
sed -i "s/DAY/${day}/g" "test/advent_of_code_2018/day_${day}_test.clj"
touch "resources/day_${day}_input.txt"