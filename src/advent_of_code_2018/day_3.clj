(ns advent-of-code-2018.day-3
  (:require [clojure.set :refer :all]))

(defn parse-claim
  [claim]
  (map clojure.edn/read-string (re-seq #"\d+" claim)))

(defn claimed-by
  [start-x start-y width height]
  (for [i (range start-y (+ start-y height))
        j (range start-x (+ start-x width))]
    (list i j)))

(defn process-claims
  [claims]
  ;; Iterate over claims
  (reduce (fn
            [[claim-map overlaps-with] claim]
            (let [[claim-id start-x start-y width height] (parse-claim claim)]
              ;; Iterate over squares in claim
              (reduce (fn
                        [[claim-map overlaps-with] square]
                        (let [claims-made (conj (claim-map square #{}) claim-id)]
                          (list
                           ;; claim-map
                           (assoc claim-map square claims-made)
                           ;; overlaps-with
                           (if (= (count claims-made) 1)
                             overlaps-with
                             (merge overlaps-with (reduce
                                                   (fn 
                                                     [new-map claim-id]
                                                     (assoc new-map claim-id (disj (union (overlaps-with claim-id) claims-made) claim-id)))
                                                   {}
                                                   claims-made))))))
                      (list claim-map (assoc overlaps-with claim-id #{}))
                      (claimed-by start-x start-y width height))))
          (list {} {})
          claims))

(defn part-1
  [claim-map]
  (reduce (fn [contested claims-made]
            (if (> (count claims-made) 1)
              (inc contested)
              contested))
          0
          (vals claim-map)))

(defn part-2
  [overlaps-with]
  (first (nth
          (filter
           (fn
             [[_ v]]
             (= (count v) 0))
           overlaps-with)
          0)))