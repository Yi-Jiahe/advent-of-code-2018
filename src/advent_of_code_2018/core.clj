(ns advent-of-code-2018.core
  (:gen-class)
  (:require [advent-of-code-2018.day-1 :as day1]))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn parse-input
  "Slurps file into a vector, seperating elements by line breaks"
  [filepath]
  (clojure.string/split (slurp filepath) #"\r?\n|\n"))

(defn run
  [day]
  (cond 
    (= 1) (let [input (parse-input "./resources/day_1_input.txt")]
            (do 
              (println "The resultant frequency is" (day1/part-1 input))
              (println "The first frequency reached twice is" (day1/part-2 input))))))
