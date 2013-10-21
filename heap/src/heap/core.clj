(ns heap.core (:gen-class))

(def input-pattern  #"(?m)^[0-9]|^I\s[0-9]+|E|^C\s[0-9]+\s[0-9]+|^D\s[0-9]+");get over it, regex is so much fun

(defn left 
"get my wrong child"
[i] (+ (* 2 i) 1))

(defn right 
"get my right child"
[i] (+ (* 2 i) 2))

(defn get-greatest [slice & us]
	 apply max (map slice (apply vector us))
	)
(defn parent 
"get my parent, you choose which"
 [i] / i 2)


(defn swap [slice one two] (assoc slice two (slice one) one (slice two)))
(defn max-heapify [slice & me]
	(let []
	))

(defn -main
"heap operations"
[& args]
	print "what"
	(let [
		numbers  (apply vector 
			(map #(. Integer parseInt %) 
				(filter #(re-matches #"[0-9]+" %) 
					 (re-seq input-pattern  (slurp "in.txt")))))
		]
		(max-heapify numbers 0)))