(ns advent-of-code-2018.day-4)

(defn parse-date
  "Parses datetimes in the format [YYYY-MM-DD HH:mm] to a number representing the datetime"
  [datetime]
  (clojure.edn/read-string (clojure.string/replace datetime #"[- :]" "")))

(defn get-minute
  "Returns minute from datetimes"
  [datetime]
  (Integer/parseInt (second (clojure.string/split datetime #":"))))

(defn parse-record
  "Splits a record (line of the input) into a list containing the date and message component"
  [record]
  (subvec (re-matches #"\[(.*)\] (.*)" record) 1))

(defn sort-records-by-date
  "Sorts the records by their date component"
  [records]
  (sort-by
   (fn [record]
     (parse-date (first (parse-record record))))
   records))

(defn compile-sleeps
  "Parses the sorted records into a map of sleeps in the form {guard [[start end] ...]}"
  [sorted-records]
  ((reduce
    (fn [{:keys [sleeps current-sleep] :as acc} record]
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
    {:sleeps {} :current-sleep {:guard nil :start nil}}
    sorted-records)
   :sleeps))

(defn compile-time-slept-by-guards
  "Returns a map of guards and the total time spent sleeping across all days from the list of sleeps"
  [sleeps]
  (reduce
   (fn [time-sleeping [guard sleep-times]]
     (assoc time-sleeping guard (reduce
                                 (fn [time-asleep [start end]]
                                   (+ time-asleep (reduce - (map parse-date [end start]))))
                                 0
                                 sleep-times)))
   {}
   sleeps))

(defn compile-times-slept-per-minute-by-guard
  "Returns a map of how many times a guard was asleep for each minute from the list of sleeps"
  [sleeps guard]
  (reduce
   (fn [acc [start end]]
     (reduce (fn [acc minute]
               (if (contains? acc minute)
                 (assoc acc minute (inc (acc minute)))
                        (assoc acc minute 1)))
             acc
             (apply range (map get-minute [start end]))))
   {}
    (sleeps guard)))

(defn find-sleepiest-guard
  [sleeps]
  (key (apply max-key val (compile-time-slept-by-guards sleeps))))

(defn find-sleepiest-minute-by-guard
  [sleeps guard]
  (key (apply max-key val (compile-times-slept-per-minute-by-guard sleeps guard))))

(defn setup
  "Transforms input into sleeps for part 1 and 2 to process"
  [input]
  (compile-sleeps (sort-records-by-date input)))

(defn part-1
  [sleeps]
  (let [sleepiest-guard (find-sleepiest-guard sleeps)
        sleepiest-minute (find-sleepiest-minute-by-guard sleeps sleepiest-guard)]
    (* (Integer/parseInt sleepiest-guard) sleepiest-minute)))

(defn part-2
  [sleeps]
  ())