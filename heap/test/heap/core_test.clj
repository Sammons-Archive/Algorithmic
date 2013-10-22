(ns heap.core-test
  (:require [clojure.test :refer :all]
            [heap.core :refer :all]))


(deftest test-greatest-finder
  (is (= (get-greatest [0 1 2] 0 1) 1)))

(deftest test-regex
	(let [ nums (apply vector 
		( cons 0  
			(apply vector 
				(map #(. Integer parseInt %) (re-seq #"(?m)^[0-9]" "1\n2\n3\n4\nE\nE")))))
		]
		(is (= nums [0 1 2 3 4]))
	))

(deftest test-file (is (not= (slurp "in.txt") nil)))

(deftest test-swap (is (= (swap [1 2 3] 2 1) [1 3 2])))

(deftest test-spit 
	(log "write " "what")
	(is (= "what" (slurp "log.txt"))))
;(deftest test-main (= (-main "in.txt") ()))

