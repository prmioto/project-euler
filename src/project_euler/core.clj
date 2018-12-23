(ns project-euler.core)

(defn find-first [f coll]
    (first (filter f coll)))

(defn divisors [n]
  (filter #(zero? (mod n %)) (range 1 (inc n))))
  
(defn composite? [n]
    (> (count (divisors n)) 2))
    
(defn prime? [n]
    (and (> n 1) (not (composite? n))))

(defn odd-composites []
    (filter composite? (filter odd? (iterate inc 1))))    
        
(defn primes-below [n]
  (loop [coll (range 2 n) primes []]
    (if (empty? coll)
      primes
      (let [p (first coll)]
          (recur (filter #(not (zero? (mod %1 p))) (rest coll)) (conj primes p))))))

(defn primes []
    (filter prime? (iterate inc 1)))
    
(defn prime-factors [n]
  (filter #(zero? (mod n %)) (primes-below (inc (int (/ n 2))))))

(defn str-to-bigint [s]
    (clojure.lang.BigInt/fromBigInteger (BigInteger. s)))