(ns advent-of-code-2018.day-5)

(def same-letter-different-case-pattern #"([a-zA-Z])(?!\1)(?i:\1)")

(defn react
  [chain]
  (clojure.string/replace chain same-letter-different-case-pattern ""))

(defn part-1
  [chain]
  (count (loop [previous-chain chain
                reacted-chain (react chain)]
           (if (= reacted-chain previous-chain)
             reacted-chain
             (recur reacted-chain (react reacted-chain))))))