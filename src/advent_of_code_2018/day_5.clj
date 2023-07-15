(ns advent-of-code-2018.day-5)

(def same-letter-different-case-pattern 
  ; Matches pairs of repeated characters with alternate casing
  #"([a-zA-Z])(?!\1)(?i:\1)")

(defn react
  "Remove all units which can trigger a reaction, i.e. remove all matches to the pattern"
  [chain]
  (clojure.string/replace chain same-letter-different-case-pattern ""))

(defn part-1
  [chain]
  (count (loop [previous-chain chain
                reacted-chain (react chain)]
           (if (= reacted-chain previous-chain) 
             reacted-chain
             (recur reacted-chain (react reacted-chain))))))

(defn alphabet-range 
  "Returns a list of characters from a to z"
  []
  (map char (range 97 123)))

(defn part-2
  [chain]
  (reduce
   (fn [acc simplified-chain] 
     (min acc (part-1 simplified-chain)))
   (count chain)
   (map #(clojure.string/replace chain (re-pattern (str "(?i)" %)) "") (alphabet-range))))