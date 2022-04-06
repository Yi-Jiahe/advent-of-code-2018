(ns advent-of-code-2018.day-1)

(defn part-1
  [frequency-changes]
  (reduce + (map clojure.edn/read-string frequency-changes)))

(defn part-2
  [frequency-changes]
  (let [n (count frequency-changes)
        frequency-changes (map clojure.edn/read-string frequency-changes)]
    (println frequency-changes)
    (loop [i 0
           frequency 0
           seen-frequencies #{}]
      (if (contains? seen-frequencies frequency)
        frequency
        (let [next-frequency (+ frequency (get frequency-changes i))]
          (recur (if (= i (- n 1))
                   0
                   (inc i))
                 next-frequency
                 (conj seen-frequencies next-frequency)))))))
