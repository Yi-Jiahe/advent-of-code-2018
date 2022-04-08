(ns advent-of-code-2018.day-3-test
  (:require [clojure.test :refer :all]
            [advent-of-code-2018.day-3 :refer :all]))

(deftest parse-claim-test
  (testing "Parse claim into (id, start-left, start-top, width, height)")
  (is (= (parse-claim "#123 @ 3,2: 5x4") '(123 3 2 5 4))))

(deftest claimed-by-test
  (testing "Square inches returned by claim")
  (is (= (claimed-by 3 2 5 4) 
         (list '(2 3) '(2 4) '(2 5) '(2 6) '(2 7)
               '(3 3) '(3 4) '(3 5) '(3 6) '(3 7)
               '(4 3) '(4 4) '(4 5) '(4 6) '(4 7)
               '(5 3) '(5 4) '(5 5) '(5 6) '(5 7)))))

;; (deftest get-claim-map-test
;;   (testing "List claims to squares"
;;     (is (= (get-claim-map '("#1 @ 1,3: 4x4"
;;                             "#2 @ 3,1: 4x4"
;;                             "#3 @ 5,5: 2x2"))
;;            {'(1 4) '(2), '(1 5) '(2)}))))

;; ;; ........
;; ;; ...2222.
;; ;; ...2222.
;; ;; .11XX22.
;; ;; .11XX22.
;; ;; .111133.
;; ;; .111133.
;; ;; ........

(deftest part-1-test
  (testing "..."
    (is (= (part-1 '("#1 @ 1,3: 4x4"
                     "#2 @ 3,1: 4x4"
                     "#3 @ 5,5: 2x2")) 4))))