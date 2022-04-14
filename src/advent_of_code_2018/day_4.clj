(ns advent-of-code-2018.day-4)

(defn parse-date
  "Parses datetimes in the format [YYYY-MM-DD HH:mm] to a number representing the datetime"
  [datetime]
  (clojure.edn/read-string (clojure.string/replace datetime #"[- :]" "")))

(defn parse-record
  [record]
  (subvec (re-matches #"\[(.*)\] (.*)" record) 1))

(defn sort-records-by-date
  [records]
  (sort-by
   (fn [record]
     (parse-date (first (parse-record record))))
   records))

(defn parse-message
  [{:keys [sleeps current-sleep] :as acc} record]
  (let [[datetime message] (parse-record record)]
    (cond
      (clojure.string/starts-with? message "Guard") (let [guard (nth (first (re-seq #"#([0-9]+)" message)) 1)]
                                                        (assoc acc
                                                               :current-sleep
                                                               {:guard guard :start nil}))
      (= message "falls asleep") (assoc acc
                                        :current-sleep
                                        (assoc current-sleep :start datetime))
      (= message "wakes up") (assoc acc
                                    :sleeps
                                    (assoc sleeps 
                                           (current-sleep :guard) 
                                           (conj (sleeps (current-sleep :guard) []) [(current-sleep :start) datetime]))))))

(defn part-1
  [sorted-records]
  (reduce
   parse-message 
   {:sleeps {}:current-sleep {:guard nil :start nil}}
   sorted-records))