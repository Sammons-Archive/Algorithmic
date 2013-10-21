(ns heap.core-test
  (:require [clojure.test :refer :all]
            [heap.core :refer :all]))

(deftest test-greatest-finder
  (= (get-greatest [0 1 2] 0 1) 1))
(deftest test-regex
	(= (apply vector (map #(. Integer parseInt %) (filter #(re-matches #"[0-9]+" %) (re-seq input-pattern "0 1 2 4 E"))))
		[0 1 2 4])
	)