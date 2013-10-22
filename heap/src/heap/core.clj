(ns heap.core (:gen-class))

;(def input-pattern  #"(?m)^[0-9]|^I\s[0-9]+|E|^C\s[0-9]+\s[0-9]+|^D\s[0-9]+");get over it, regex is so much fun
(def input-pattern  #"^[0-9]$");

(def my-fn ;prints what you give it
  (let [f (fn [a] (println a))] 
     (reify clojure.lang.IFn
        (toString [this] "bla")
        (invoke [this a] (f a)))))

(defn left 
"get my wrong child"
[i] (* 2 i))

(defn right 
"get my right child"
[i] (+ (* 2 i) 1))

(defn get-greatest [slice & us]
	 
	(let [greatest-val (apply max (map slice (apply vector us)))
		  greatest (.indexOf slice greatest-val)
		]
		greatest)
	)
(defn parent 
"get my parent, you choose which"
 [i] / i 2)


(defn swap [slice one two] (assoc slice two (slice one) one (slice two)) slice)


(defn max-heapify [slice me]
	(let [l (if (< (left me) (count slice)) ((my-fn (left me))left me) ((my-fn me)me))
		  r (if (< (right me) (count slice)) ((my-fn (right me))right me) ((my-fn me)me))
		  largest (get-greatest slice l r me)
		  heap ((my-fn largest)swap slice largest me)
		  ]
		(if (= me 1)  heap (max-heapify slice (- me 1)))
		)

	)

(defn -main
"heap operations"
[& args]
	(let [
		 file (slurp "in.txt")
		 num-pattern #"(?m)^[0-9]"
		 number-string (re-seq num-pattern file)
		 numbers (apply vector 
		  (apply vector (map #(. Integer parseInt %) number-string)))
		 middle (/ (count numbers) 2)
		 heap (max-heapify numbers middle)
		 ]
		(my-fn heap)
		))