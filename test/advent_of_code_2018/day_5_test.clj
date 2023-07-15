(ns advent-of-code-2018.day-5-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day-5 :refer :all]))

(deftest reaction-test
  (testing "large-then-small"
    (is (= (react "aBbc") "ac")))
  (testing "small then large"
    (is (= (react "abBc") "ac")))
  (testing "same polarity"
    (is (= (react "aa") "aa"))
    (is (= (react "AA") "AA"))))

(deftest part-1-test
  (testing "Part 1"
    (is (= (part-1 "aA") 0))
    (is (= (part-1 "abBA") 0))
    (is (= (part-1 "abAB") 4))
    (is (= (part-1 "aabAAB") 6))
    (is (= (part-1 "dabAcCaCBAcCcaDA") 10))))