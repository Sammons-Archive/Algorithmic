(ns heap.core
  (:gen-class))

(defn get-command-line-args [i] 
	"gets ith command line argument"
	(nth *command-line-args* i))

(def ARGV (get-command-line-args 0))

(defn -main
  "heap operations"
  [& args]
  (let [
  	file ARGV

  	])
  (print ARGV))

