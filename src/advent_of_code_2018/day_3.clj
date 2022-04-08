(ns advent-of-code-2018.day-3)

(defn parse-claim
  [claim]
  (map clojure.edn/read-string (re-seq #"\d+" claim)))

(defn claimed-by
  [start-x start-y width height]
    (for [i (range start-y (+ start-y height))
          j (range start-x (+ start-x width))]
      (list i j)))

(defn get-claim-map
  [claims]
  (reduce (fn [claimed claim]
            (let [[claim-id start-x start-y width height] (parse-claim claim)]
              (reduce (fn [claimed square]
                        (assoc claimed square (conj (claimed square (list)) claim-id)))
                      claimed
                      (claimed-by start-x start-y width height))))
          {}
          claims))

(defn part-1
  [claims]
  (reduce (fn [contested claims-made]
            (if (> (count claims-made) 1)
              (inc contested)
              contested)) 
          0
          (vals (get-claim-map claims))))