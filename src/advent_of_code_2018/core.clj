(ns advent-of-code-2018.core
  (:gen-class)
  (:require [advent-of-code-2018.day-1 :as day1]
            [advent-of-code-2018.day-2 :as day2]
            [advent-of-code-2018.day-3 :as day3]
            [advent-of-code-2018.day-4 :as day4]
            [advent-of-code-2018.day-5 :as day5]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn parse-input
  "Seperates string by line breaks"
  [input]
  (clojure.string/split input #"\r?\n|\n"))

(defn run
  [day]
  (cond
    (= day 1) (let [input (parse-input (slurp "./resources/day_1_input.txt"))]
                (println "The resultant frequency is" (day1/part-1 input))
                (println "The first frequency reached twice is" (day1/part-2 input)))
    (= day 2) (let [input (parse-input (slurp "./resources/day_2_input.txt"))]
                (println "The checksum is" (day2/part-1 input))
                (println "The correct IDs are" (day2/part-2 input)))
    (= day 3) (let [[claim-map overlaps-with] (day3/process-claims (parse-input (slurp "./resources/day_3_input.txt")))]
                (println "Claims Processed")
                (println (day3/part-1 claim-map) "square inches are within 2 or more claims")
                (println "Claim" (day3/part-2 overlaps-with) "has no overlaps"))
    (= day 4) (let [sleeps (day4/setup (parse-input (slurp "./resources/day_4_input.txt")))]
                (println "Part 1 Answer: " (day4/part-1 sleeps))
                (println "Part 2 Answer: " (day4/part-2 sleeps)))
    (= day 5) (let [input (parse-input (slurp "./resources/day_5_input.txt"))]
                (println "The lenght of the final chain is " (day5/part-1 input)))))
          

