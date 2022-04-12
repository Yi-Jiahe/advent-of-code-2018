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

(defn part-1
  [sorted-records]
  (reduce (fn 
            [results-map [datetime message]] 
            results-map)
          {}
          sorted-records))