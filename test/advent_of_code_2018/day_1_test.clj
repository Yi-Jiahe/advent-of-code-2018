(ns advent-of-code-2018.day-1-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day-1 :refer :all]))

(deftest part-1-test
  (testing "Part 1"
    (is (= (part-1 ["+1" "-2" "+3" "+1"]) 3))
    (is (= (part-1 ["+1" "+1" "+1"]) 3))
    (is (= (part-1 ["+1" "+1" "-2"]) 0))
    (is (= (part-1 ["-1" "-2" "-3"]) -6))))

(deftest part-2-test
  (testing "Part 2"
    (is (= (part-2 ["+1" "-2" "+3" "+1"]) 
           2))
    (is (= (part-2 ["+1" "-1"])
           0))
    (is (= (part-2 ["+3" "+3" "+4" "-2" "-4"])
           10))
    (is (= (part-2 ["-6" "+3" "+8" "-5" "-6"])
           5))
    (is (= (part-2 ["+7" "+7" "-2" "-7" "-4"])
           14))))
