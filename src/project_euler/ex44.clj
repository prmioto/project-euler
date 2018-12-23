(ns project-euler.ex44
    (:require [clojure.math.numeric-tower :as math]))

(defn pentagon-number [n]
    (/ (* n (- (* 3 n) 1)) 2))

(defn calc-quadratic-roots [a b c]
    (let [square-root (math/sqrt (- (* b b) (* 4 a c)))]
        [(/ (+ (* -1 b) square-root) (* 2 a))
         (/ (- (* -1 b) square-root) (* 2 a))]))
         
(defn is-pentagon-number? [n]
    (integer? (first (calc-quadratic-roots 3 -1 (* -2 n)))))