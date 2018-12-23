(ns project-euler.ex45
  (:gen-class)
  (:require [clojure.math.numeric-tower :as math]))

(defn calc-quadratic-roots [a b c]
    (let [square-root (math/sqrt (- (* b b) (* 4 a c)))]
        [(/ (+ (* -1 b) square-root) (* 2 a))
         (/ (- (* -1 b) square-root) (* 2 a))]))

(defn triangle-number [n]
    (/ (* n (+ 1 n)) 2))
         
(defn is-triangle-number? [tn]
    (integer? (first (calc-quadratic-roots 1 1 (* -2 tn)))))
    
(defn pentagonal-number [n]
    (/ (* n (- (* 3 n) 1)) 2))
         
(defn is-pentagonal-number? [pn]
    (integer? (first (calc-quadratic-roots 3 -1 (* -2 pn)))))
    
(defn hexagonal-number [n]
    (* n (- (* 2 n) 1)))
         
(defn is-hexagonal-number? [hn]
    (integer? (first (calc-quadratic-roots 2 -1 (* -1 hn)))))
    
(defn is-triangle-pentagonal-hexagonal-number? [tphn]
    (and 
        (is-triangle-number? tphn)
        (is-pentagonal-number? tphn)
        (is-hexagonal-number? tphn)))
          
(defn find-next-number [start]
    (first (take 1 (filter is-triangle-pentagonal-hexagonal-number? (iterate inc start)))))

(defn -main [& args]
    (println (find-next-number (inc 40755))))
;answer: 1533776805