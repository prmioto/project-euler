(ns project-euler.ex60
    (:require [project-euler.core :as core]))

(defn combinations [coll n]
  (letfn [(recur-combinations [elems k comb]
            (if 
              (= k 1)
              (map #(conj comb %) elems)
              (apply concat
                (map 
                  #(recur-combinations
                     (rest (nthnext elems %))
                     (dec k)
                     (conj
                       comb
                       (first (nthnext elems %))))
                  (range 0 (inc (- (count elems) k)))))))]
    (recur-combinations (vec coll) n [])))

(defn concatenate-numbers [n1 n2]
    (core/str-to-bigint (str (str n1) (str n2))))

(defn prime-pair-set? [prime-coll]
  (let [combs (combinations prime-coll 2)]
    (= (count combs)
       (count 
         (filter 
           true?
           (map 
             #(and
                   (core/prime? (concatenate-numbers (first %) (second %)))
                   (core/prime? (concatenate-numbers (second %) (first %))))
             combs))))))

(prime-pair-set? [7 109])
(prime-pair-set? [3 7 109 673])

(println
(sort <
    (map 
        #(apply + %)
        (filter 
         prime-pair-set? 
         (combinations (core/primes-below 100) 5))))
)