(ns project-euler.ex50
  (:gen-class)
  (:require [project-euler.core :as core]))

(defn primes-coll [n]
  (let [primes (core/primes-below n)]
    (map
      #(nthrest primes %)
      (range (dec (count primes))))))

(defn sum-n-items [coll n]
  (reduce + 0 (take n coll)))

(sum-n-items (core/primes-below 20) 4)

(defn gen-start-end-indexes [n]
  (reduce
    #(concat %1 %2)
    ()
    (map
      (fn [i]
        (map
          (fn [j]
            (list i j))
          (range (inc i) n)))
      (range 0 n))))

(gen-start-end-indexes 5)

(defn calc-sequence-primes [max-lim]
  (let [primes (core/primes-below max-lim)]
    (map
      #(subvec primes (first %) (inc (second %)))
      (gen-start-end-indexes (count primes)))))
      
(defn longest-sum-of-consecutive-primes-below [max-lim]
    (:sum
        (first
          (sort
            #(> (%1 :len) (%2 :len))
            (filter
              #(and (core/prime? (%1 :sum)) (< (%1 :sum) 100))
              (map #(assoc {} :sum (apply + %1) :seq %1 :len (count %1)) (calc-sequence-primes max-lim)))))))

(comment
(first
  (sort
    #(> (%1 :len) (%2 :len))
    (filter
      #(and (core/prime? (%1 :sum)) (< (%1 :sum) 100))
      (map #(assoc {} :sum (apply + %1) :seq %1 :len (count %1)) (calc-sequence-primes 5000)))))
)

(comment
  {:sum 953, :seq [7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89], :len 21})
  

(comment {:sum 997651,  :len 543})
