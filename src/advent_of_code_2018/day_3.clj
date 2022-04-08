(ns advent-of-code-2018.day-3)

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
  (reduce (fn [[claim-map overlaps-with] claim]
            (let [[claim-id start-x start-y width height] (parse-claim claim)]
              (reduce (fn [[claim-map overlaps-with] square]
                        (let [conflicting-claims (claim-map square)]
                          (list
                           (assoc claim-map square (conj (claim-map square (list)) claim-id))
                           (if (empty? conflicting-claims)
                             (assoc overlaps-with claim-id #{})
                             (apply assoc overlaps-with (conj () claim-id (into #{} conflicting-claims)))))))
                      (list claim-map overlaps-with)
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
  [overlaps-with])