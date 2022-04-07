(ns advent-of-code-2018.day-2)

(defn has-two-or-three
  [box-ID]
  (let [appearences (into #{} (vals (frequencies box-ID)))]
    (hash-map
     :2 (if (contains? appearences 2) 1 0)
     :3 (if (contains? appearences 3) 1 0))))

(defn part-1
  [box-IDs]
  (let [appearences (reduce
                     (fn [twos-and-threes box-ID]
                       (let [appearences (has-two-or-three box-ID)]
                         (assoc twos-and-threes
                                :2 (+ (:2 twos-and-threes)
                                      (:2 appearences))
                                :3 (+ (:3 twos-and-threes)
                                      (:3 appearences)))))
                     (hash-map :2 0 :3 0)
                     box-IDs)]
    (* (:2 appearences 0) (:3 appearences 0))))

(defn correct-IDs?
  [ID-1 ID-2]
  (if (= (count ID-1) (count ID-2))
    (loop [i 0
           differences 0]
      (if (= i (count ID-1))
        (if (= differences 1)
          true
          false)
        (if (> differences 1)
          false
          (if (= (nth ID-1 i) (nth ID-2 i))
            (recur (inc i) differences)
            (recur (inc i) (inc differences))))))
    false))

(defn part-2
  [box-IDs]
  (let [n (count box-IDs)]
    (loop [i 0]
      (let [found? (loop [j (inc i)]
                       (if (= n j)
                         false
                         (let [ID-1 (nth box-IDs i)
                               ID-2 (nth box-IDs j)]
                           (if (correct-IDs? ID-1 ID-2)
                             (list ID-1 ID-2)
                             (recur (inc j))))))]
        (if found?
          found?
          (recur (inc i)))))))
