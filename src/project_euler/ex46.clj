(ns project-euler.ex46
  (:gen-class)
  (:require [project-euler.core :as core]
            [clojure.math.numeric-tower :as math]))
  
(defn is-square? [n]
    (integer? (math/sqrt n)))
    
(defn is-goldbach-conjecture? [n np]
    ;(println n np (/ (- n np) 2))
    (if (< n np)
        false
        (is-square? (/ (- n np) 2))))

(defn find-goldbach-prime [n]
    (println n)
    (core/find-first 
        #(is-goldbach-conjecture? n %)
        (take-while #(< % n) (core/primes))))
            
(defn find-first-conjecture-failure []
    (core/find-first 
        #(nil? %)
        (map #(find-goldbach-prime %) (core/odd-composites))))

(defn -main [& args]
    (println (find-first-conjecture-failure)))
;answer: 5777                