(ns advent-of-code-2018.day-4-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day-4 :refer :all]
            [advent-of-code-2018.core :refer [parse-input]]))

(deftest parse-record-test
  (testing "shift start"
    (is (= (parse-record "[1518-11-01 00:00] Guard #10 begins shift") ["1518-11-01 00:00" "Guard #10 begins shift"])))
  (testing "falls asleep"
    (is (= (parse-record "[1518-11-01 00:05] falls asleep") ["1518-11-01 00:05" "falls asleep"])))
  (testing "wakes up"
    (is (= (parse-record "[1518-11-01 00:25] wakes up") ["1518-11-01 00:25" "wakes up"]))))

(deftest parse-date-test
  (testing "date string converted to number"
    (is (= (parse-date "1518-11-01 00:00") 151811010000))))

(deftest get-minute-test
  (testing "get minute from datetime string"
    (is (= (get-minute "1518-11-01 00:05") 5))))

(def example-records
  "[1518-11-01 00:00] Guard #10 begins shift
[1518-11-01 00:05] falls asleep
[1518-11-01 00:25] wakes up
[1518-11-01 00:30] falls asleep
[1518-11-01 00:55] wakes up
[1518-11-01 23:58] Guard #99 begins shift
[1518-11-02 00:40] falls asleep
[1518-11-02 00:50] wakes up
[1518-11-03 00:05] Guard #10 begins shift
[1518-11-03 00:24] falls asleep
[1518-11-03 00:29] wakes up
[1518-11-04 00:02] Guard #99 begins shift
[1518-11-04 00:36] falls asleep
[1518-11-04 00:46] wakes up
[1518-11-05 00:03] Guard #99 begins shift
[1518-11-05 00:45] falls asleep
[1518-11-05 00:55] wakes up")

(def sleeps (setup (parse-input example-records)))

(deftest sleepist-guard-test
  (testing "Find sleepiest guard"
    (is (= (find-sleepiest-guard sleeps) "10"))))

(deftest sleepiest-minute-test
  (testing "Find sleepiest minute for guard 10"
    (is (= (find-sleepiest-minute-by-guard sleeps "10") 24))))

(deftest end-to-end-test
  (testing "Example 1"
    (is (= (part-1 sleeps) 240))))

(testing "Part 2"
  (is (= (part-2 sleeps) 4455)))