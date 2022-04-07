(ns advent-of-code-2018.day-2-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day-2 :refer :all]))

(deftest part-1-test
  (testing "Part 1"
    (is (= (part-1 ["abcdef"
                    "bababc"
                    "abbcde"
                    "abcccd"
                    "aabcdd"
                    "abcdee"
                    "ababab"])
            12))))

(deftest correct-IDs?-test
  (testing "Able to correctly identify if a pair of ids are the correct ids"
    (is (false? (correct-IDs? "abcde" "axcye"))
        (true? (correct-IDs? "fghij" "fguij")))))

(deftest part-2-test
  (testing "Part 2"
    (is (= (part-2 ["abcde"
                    "fghij"
                    "klmno"
                    "pqrst"
                    "fguij"
                    "axcye"
                    "wvxyz"])
           '("fghij" "fguij")))))